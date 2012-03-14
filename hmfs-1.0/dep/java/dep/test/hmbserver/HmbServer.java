package dep.test.hmbserver;

import dep.gateway.hmb8583.HmbMessageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * �����ֶ�ģ�����SERVER
 * User: zhanrui
 * Date: 12-3-11
 * Time: ����10:12
 * To change this template use File | Settings | File Templates.
 */
public class HmbServer implements Runnable {
    private static final Logger log = LoggerFactory.getLogger(HmbServer.class);

    private static ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(1);
    private static HmbMessageFactory messageFactory;

    private Socket socket;

    HmbServer(Socket sock) throws IOException {
        socket = sock;
    }

    public void run() {
        int count = 0;
        byte[] lenbuf = new byte[7];
        try {
            while (socket != null && socket.isConnected()
                    && Thread.currentThread().isAlive() && !Thread.currentThread().isInterrupted()) {
                if (socket.getInputStream().read(lenbuf) == 7) {
                    int size = new Integer(new String(lenbuf));
                    byte[] buf = new byte[size];
                    socket.getInputStream().read(buf);
                    count++;
                    threadPool.schedule(new Processor(buf, socket), 400, TimeUnit.MILLISECONDS);
                }
            }
        } catch (IOException ex) {
            log.error("err", ex);
        }
        log.debug("�Ѵ�������������", count);
        try {
            socket.close();
        } catch (IOException ex) {}
    }

    private class Processor implements Runnable {

        private byte[] msg;
        private Socket sock;

        Processor(byte[] buf, Socket s) {
            msg = buf;
            sock = s;
        }

        public void run() {
            try {
                String msgin = new String(msg);
                log.debug("Parsing incoming: '{}'", msgin);
                String txncode = msgin.substring(0,4);

                String pkgname = TxnProcessor.class.getPackage().getName();
                Class clazz = Class.forName(pkgname + ".impl.Txn" + txncode + "Processor");
                TxnProcessor processor = (TxnProcessor) clazz.newInstance();

                byte[] gbks = processor.process(msg);
                socket.getOutputStream().write(gbks);
            } catch (Exception ex) {
                log.error("��Ӧ����:", ex);
            }
        }
    }


    //==========================================================================
    public static void main(String[] args) throws Exception {
        messageFactory = new HmbMessageFactory();
        ServerSocket server = new ServerSocket(60000);
        log.info("��ʼ���ձ���...");
        while (true) {
            Socket sock = server.accept();
            log.info("������ {}:{}", sock.getInetAddress(), sock.getPort());
            new Thread(new HmbServer(sock), "hmb-server").start();
        }
    }
}