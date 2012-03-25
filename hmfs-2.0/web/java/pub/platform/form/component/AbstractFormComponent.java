
package pub.platform.form.component;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

import pub.platform.advance.utils.PropertyManager;
import pub.platform.db.ConnectionManager;
import pub.platform.db.DBUtil;
import pub.platform.db.DatabaseConnection;
import pub.platform.db.RecordSet;
import pub.platform.form.config.ElementBean;
import pub.platform.form.config.EnumerationBean;
import pub.platform.form.config.EnumerationType;
import pub.platform.form.util.datatype.ComponentType;

/**
 *  FORM����ĳ����� Notes: 1.�������������Ե�setter��getter����
 *
 *@author     ���滻
 *@created    2003��10��10��
 *@version    1.0
 */
public abstract class AbstractFormComponent {
    /**
     *  Description of the Field
     *
     *@author    sun
     *@since     2003��10��11��
     */
    public static Logger logger = Logger.getLogger("zt.platform.form.component.AbstractComponent");



    /**
     *  FORM�������
     *
     *@author    sun
     *@since     2003��10��11��
     */
    public final static String CSS_PAGE_FORM_BUTTON = "page_form_button_active";

    /**
     *  Description of the Field
     *
     *@author    sun
     *@since     2003��10��11��
     */
    public final static String CSS_PAGE_FORM_REFBUTTON = "page_form_refbutton";
    /**
     *  FORM�������
     *
     *@author    sun
     *@since     2003��10��11��
     */
    public final static String CSS_PAGE_FORM_SELECT = "page_form_select";
    /**
     *  FORM�������
     *
     *@author    sun
     *@since     2003��10��11��
     */
    public final static String CSS_PAGE_FORM_RADIO = "page_form_radio";
    /**
     *  FORM�������
     *
     *@author    sun
     *@since     2003��10��11��
     */
    public final static String CSS_PAGE_FORM_CHECKBOX = "page_form_checkbox";
    /**
     *  FORM�������
     *
     *@author    sun
     *@since     2003��10��11��
     */
    public final static String CSS_PAGE_FORM_LABEL = "page_form_label";
    /**
     *  FORM�������
     *
     *@author    sun
     *@since     2003��10��11��
     */
    public final static String CSS_PAGE_FORM_TEXT = "page_form_text";
    /**
     *  FORM�������
     *
     *@author    sun
     *@since     2003��10��11��
     */
    public final static String CSS_PAGE_FORM_TEXTFIELD = "page_form_textfield";
    /**
     *  FORM�������
     *
     *@author    sun
     *@since     2003��10��11��
     */
    public final static String CSS_PAGE_FORM_PASSWORD = "page_form_password";
    /**
     *  FORM�������
     *
     *@author    sun
     *@since     2003��10��11��
     */
    public final static String CSS_PAGE_FORM_SUBMIT = "page_form_button_active";
    /**
     *  FORM�������
     *
     *@author    sun
     *@since     2003��10��11��
     */
    public final static String CSS_PAGE_FORM_RESET = "page_form_button_active";

    /**
     *  Page FORM
     *
     *@author    sun
     *@since     2003��10��11��
     */
    public final static String CSS_PAGE_FORM_TABLE = "page_form_table";

    /**
     *  Page FORM
     *
     *@author    sun
     *@since     2003��10��11��
     */
    public final static String CSS_PAGE_FORM_TABLE_TR = "page_form_tr";
    /**
     *  Page FORM
     *
     *@author    sun
     *@since     2003��10��11��
     */
    public final static String CSS_PAGE_FORM_TABLE_TD = "page_form_td";
    /**
     *  Page FORM
     *
     *@author    sun
     *@since     2003��10��11��
     */
    public final static String CSS_PAGE_FORM_TABLE_TITLE_TD = "page_form_title_td";

    /**
     *  ��ť����Table Table��classΪpage_form_button_table
     *  Tr��classΪpage_form_button_tr Td��classΪpage_form_button_td
     *
     *@author    sun
     *@since     2003��10��11��
     */
    public final static String CSS_PAGE_FORM_BUTTON_TABLE = "page_form_button_table";
    /**
     *  Description of the Field
     *
     *@author    sun
     *@since     2003��10��11��
     */
    public final static String CSS_PAGE_FORM_BUTTON_TR = "page_form_button_tr";

    /**
     *  List FORM Table ��class Ϊ list_form_table Tr��classΪlist_form_tr
     *  Td��classΪlist_form_td ���У������tdΪlist_form_title_td
     *
     *@author    sun
     *@since     2003��10��11��
     */
    public final static String CSS_LIST_FORM_TABLE = "list_form_table";
    /**
     *  Description of the Field
     *
     *@author    sun
     *@since     2003��10��11��
     */
    public final static String CSS_LIST_FORM_TD = "list_form_td";

    /**
     *  Description of the Field
     *
     *@author    sun
     *@since     2003��10��11��
     */
    public final static String CSS_LIST_FORM_TITLE_TD = "list_form_title_td";
    /**
     *  Description of the Field
     *
     *@author    sun
     *@since     2003��10��11��
     */
    public final static String CSS_LIST_FORM_TR = "list_form_tr";

    ElementBean element = null;


    /**
     *  Constructor for the AbstractFormComponent object
     *
     *@param  element  Description of the Parameter
     */
    public AbstractFormComponent(ElementBean element) {
        this.element = element;
        int type = element.getComponetTp();
        if (type == ComponentType.CHECKBOX_TYPE ||
                type == ComponentType.LIST_TYPE ||
                type == ComponentType.RADIO_TYPE) {
            this.initValues();
        }
    }


    /**
     *  Description of the Method
     */
    private void initValues() {

        //nameset��ʾ��ʾ���ݣ�valueset��ʾ�洢ֵ
        logger.info("Init values because the list,radio,checkbox");
        int valueSetType = this.element.getValuesettype();
        String keyAndValueStr = element.getValueset();
        logger.info("keyAndValueStr is " + keyAndValueStr);
        if (valueSetType == 1) {
            String keyAndValues[] = keyAndValueStr.split("\\|");

            this.nameset = new String[keyAndValues.length];
            this.valueset = new String[keyAndValues.length];
            for (int i = 0; i < keyAndValues.length; i++) {
                logger.info("keyAndValues[" + i + "] is :" + keyAndValues[i]);
                String keyAndValue[] = keyAndValues[i].split(":");
                valueset[i] = keyAndValue[0];
                nameset[i] = keyAndValue[1];
            }
        } else if (valueSetType == 2) {
            String[] tableAndField = keyAndValueStr.split(":");
            String sql = "select " + tableAndField[1] + "," + tableAndField[2] + " from " + tableAndField[0] + " ";
            logger.info("sql is : " + sql);
            ConnectionManager manager = ConnectionManager.getInstance();
            DatabaseConnection con = manager.getConnection();
            RecordSet rs = con.executeQuery(sql);
            this.nameset = new String[rs.getRecordCount()];
            this.valueset = new String[rs.getRecordCount()];
            logger.info("RecordSet count is : " + rs.getRecordCount());
            int i = 0;
            while (rs.next()) {
                Object o1;
                Object o2;
                o1 = rs.getObject(0);
                o2 = rs.getObject(1);
                if (o1 == null || o2 == null) {
                    logger.warning("Null name or value ");
                } else {
                    valueset[i] = o1.toString().trim();
                    nameset[i] = DBUtil.fromDB(o2.toString().trim());
                }
                i++;
            }
            con.commit();
            manager.releaseConnection(con);
        } else if (valueSetType == 3) {
            ConnectionManager manager = ConnectionManager.getInstance();
            DatabaseConnection con = manager.getConnection();
            RecordSet rs = con.executeQuery(keyAndValueStr);
            this.nameset = new String[rs.getRecordCount()];
            this.valueset = new String[rs.getRecordCount()];
            int i = 0;
            while (rs.next()) {
                Object o1;
                Object o2;
                o1 = rs.getObject(0);
                o2 = rs.getObject(1);
                if (o1 == null || o2 == null) {
                    logger.warning("Null name or value ");
                } else {
                    valueset[i] = o1.toString().trim();
                    nameset[i] = DBUtil.fromDB(o2.toString().trim());
                }

                i++;
            }
            con.commit();
            manager.releaseConnection(con);
        } else if (valueSetType == 4) {
//            String enuname = element.getEnutpname();
            String enuname = keyAndValueStr;
            if (enuname == null || enuname.equals("")) {
                logger.severe("Please set the " + element.getName() + "'s enum enuname");
            } else {
                EnumerationBean enu = EnumerationType.getEnu(enuname);
                if (enu == null) {
                    logger.severe("Please config the " + element.getName() +
                            "'s enum with enuname of " + enuname);
                } else {
                    Map enus = enu.getEnu();
                    this.nameset = new String[enus.size()];
                    this.valueset = new String[enus.size()];
                    int i = 0;
                    for (Iterator iter = enus.keySet().iterator(); iter.hasNext(); ) {
                        Object key = (Object) iter.next();
                        Object value = enu.getValue(key);
                        valueset[i] = key.toString();
                        nameset[i] = value.toString();
                        i++;
                    }

                }
            }
        } else {
            logger.severe("values set type is unknown " + valueSetType);
        }
    }


    private static Map components;

    static {
        components = new HashMap();
        components.put(new Integer(ComponentType.BOOLEAN_TYPE), "zt.platform.form.component.DbBoolean");
        components.put(new Integer(ComponentType.ENUMERATION_TYPE), "zt.platform.form.component.DbEnumeration");
        components.put(new Integer(ComponentType.REFERENCE_TEXT_TYPE), "zt.platform.form.component.DbRefText");
        components.put(new Integer(ComponentType.TEXT_TYPE), "zt.platform.form.component.DbText");
        components.put(new Integer(ComponentType.BUTTON_TYPE), "zt.platform.form.component.FormButton");

        components.put(new Integer(ComponentType.CHECKBOX_TYPE), "zt.platform.form.component.FormCheckBox");
        components.put(new Integer(ComponentType.HIDDEN_TYPE), "zt.platform.form.component.FormHidden");
        components.put(new Integer(ComponentType.JAVASCIPT_TYPE), "zt.platform.form.component.FormJavaScript");
        components.put(new Integer(ComponentType.LABEL_TYPE), "zt.platform.form.component.FormLabel");
        components.put(new Integer(ComponentType.LIST_TYPE), "zt.platform.form.component.FormList");

        components.put(new Integer(ComponentType.PASSWORD_TYPE), "zt.platform.form.component.FormPassword");
        components.put(new Integer(ComponentType.RADIO_TYPE), "zt.platform.form.component.FormRadio");
        components.put(new Integer(ComponentType.RESET_TYPE), "zt.platform.form.component.FormReset");
        components.put(new Integer(ComponentType.SUBMIT_TYPE), "zt.platform.form.component.FormSubmit");
        components.put(new Integer(ComponentType.TEXTAREA_TYPE), "zt.platform.form.component.FormTextArea");
        components.put(new Integer(ComponentType.DATE_TYPE), "zt.platform.form.component.FormDate");

    }

    /**
     *  Description of the Field
     *
     *@author    sun
     *@since     2003��10��11��
     */
    protected String[] nameset;
    /**
     *  Description of the Field
     *
     *@author    sun
     *@since     2003��10��11��
     */
    protected String[] valueset;

//    /**
//     * ���ֶ��뷽��(left��right��center)
//     */
//    protected String align;
//
//    /**
//     * �߿�ߴ�
//     */
//    protected String border;
//
//    /**
//     * HTML�����classֵ
//     */
//    protected String cClass;
//
//    /**
//     * �������ʽ���
//     */
//    protected String style;
//
//    /**
//     * �߶�
//     */
//    protected int height;
//
//    /**
//     * ����
//     */
//    protected int width;
//
//    /**
//     * �����Ƿ����У�����textarea��
//     */
//    protected String wrap;
//
//    /**
//     * �����TAB�����
//     */
//    protected String tabindex;
//
//    /**
//     * ID
//     */
//    protected String id;
//
//    /**
//     * ����
//     */
//    protected String title;
//
//    /**
//     * ����
//     */
//    protected String name;
//
//    /**
//     * �������
//     */
//    protected String type;
//
//    /**
//     * ��������
//     */
//    protected String datatype;
//
//    /**
//     * �����ֵ
//     */
    /**
     *  Description of the Field
     *
     *@author    sun
     *@since     2003��10��11��
     */
    private String[] value;

//

//    /**
//     * �Ƿ�ѡ�У�����checkbox��radio
//     */
//    protected boolean checked;
    /**
     *  Description of the Field
     *
     *@author    sun
     *@since     2003��10��11��
     */
    protected boolean readonly = false;
    protected pub.platform.form.control.SessionContext ctx;
    private String instanceId;
    private boolean changeEvent;


//

//    /**
//     * �Ƿ�ɼ������ɼ�һ��ת����hidden��ǩ
//     */
//    protected boolean visible;
//
//    /**
//     * �Ƿ�ʧЧ
//     */
//    protected boolean disabled;
//
//    /**
//     * �ߴ��С
//     */
//    protected int size;
//
//    /**
//     * ��С����
//     */
//    protected int minlength;
//
//    /**
//     * ��󳤶�
//     */
//    protected int maxlength;
//
//    /**
//     * �к�
//     */
//    protected int rows;
//
//    /**
//     * �к�
//     */
//    protected int cols;
//
//    /**
//     * �Ƿ�������ѡ
//     */
//    protected boolean multiple;
//
//    /**
//     * ͷ��΢������
//     */
//    protected String headstr;
//
//    /**
//     * �м�΢������
//     */
//    protected String middlestr;
//
//    /**
//     * β��΢������
//     */
//    protected String afterstr;
//
//    /**
//     * �������ԣ����ʽΪ
//     * a1=1|a2=2|a3=3��ʹ��ʱ���뽫���
//     */
//    protected String others;

    /**
     *@return     String
     *@roseuid    3F738709032D
     */
    public String toHTML() {
        return "error";
    }


    /**
     *  ��ʼ�� ����e��������Գ�ʼ��������
     *
     *@param  e
     *@roseuid    3F7EA0DD0366
     */
    protected void init(ElementBean e) { }


    /**
     *  ����ElementBean��ʵ��e����һ��AbstarctFormComponentʵ�������ľ������Ͱ���ö�٣�e
     *  numration�����ο����ı���(reference text)����������(boolean)
     *  �ı���text�����ı�����(textarea)��������(hidden)����ѡ��(checkbox)��
     *  ��ѡ��ť(radio)������ʽ�б�(list)���ı���ǩ(label)���ű�(js)����ť��button����
     *  �ύ��submit�������ã�reset���� ���������ComponentType���Ѿ����塣
     *
     *@param  e
     *@return     zt.platform.form.component.AbstractFormComponent
     *@roseuid    3F73FFE8016E
     */
    public static AbstractFormComponent getInstance(ElementBean e) {
        int type = e.getComponetTp();
//        System.out.println(e.getName()+"==="+e.getComponetTp());
        Class c = null;
        try {
            c = Class.forName((String) components.get(new Integer(type)));
            ClassLoader cl = c.getClassLoader();
            try {
                Object o[] = {e};
                AbstractFormComponent com = (AbstractFormComponent) c.getConstructors()[0].newInstance(o);
                return com;
            } catch (Exception ex1) {
                ex1.printStackTrace();
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return null;
        }
        return null;
    }


    /**
     *  Gets the value attribute of the AbstractFormComponent object
     *
     *@return    The value value
     */
    public String[] getValues() {
        if (this.value == null) {
            String v[] = {""};
            return v;
        }
        for (int i = 0; i < value.length; i++) {
            if (value[i] == null) {
                value[i] = "";

            }
        }
        return value;
    }


    /**
     *  Sets the value attribute of the AbstractFormComponent object
     *
     *@param  value  The new value value
     */
    public void setValues(String[] value) {
        this.value = value;
    }


    /**
     *  Gets the valueset attribute of the AbstractFormComponent object
     *
     *@return    The valueset value
     */
    public String[] getValueset() {
        return valueset;
    }


    /**
     *  Sets the valueset attribute of the AbstractFormComponent object
     *
     *@param  valueset  The new valueset value
     */
    public void setValueset(String[] valueset) {
        this.valueset = valueset;
    }


    /**
     *  Gets the nameset attribute of the AbstractFormComponent object
     *
     *@return    The nameset value
     */
    public String[] getNameset() {
        return nameset;
    }


    /**
     *  Sets the nameset attribute of the AbstractFormComponent object
     *
     *@param  nameset  The new nameset value
     */
    public void setNameset(String[] nameset) {
        this.nameset = nameset;
    }


    /**
     *  Gets the readonly attribute of the AbstractFormComponent object
     *
     *@return    The readonly value
     */
    public boolean isReadonly() {
        return readonly;
    }


    /**
     *  Sets the readonly attribute of the AbstractFormComponent object
     *
     *@param  readonly  The new readonly value
     */
    public void setReadonly(boolean readonly) {
        this.readonly = readonly;
    }


    /**
     *  Description of the Method
     *
     *@return    Description of the Return Value
     */
    public static boolean useTd() {
        if (PropertyManager.getProperty("zt.platform.component.TdSeparatorIsUsed") == null) {
            return true;
        } else {
            return PropertyManager.getProperty("zt.platform.component.TdSeparatorIsUsed").equals("true");
        }
    }


    /**
     *  Gets the header attribute of the AbstractFormComponent object
     *
     *@return    The header value
     */
    protected String getHeader() {
        String tmp = "";
        if ( !element.isIsnull() ) {
            tmp = "*";
        }
        if (useTd()) {
            String header = "<td class=\"" + CSS_PAGE_FORM_TABLE_TITLE_TD + "\" nowrap>" +
                    element.getCaption() + tmp +
                    "</td><td class=\"" + CSS_PAGE_FORM_TABLE_TD + "\" >" + element.getHeadstr();
            return header;
        } else {
            String header = "<td class=\"" + CSS_PAGE_FORM_TABLE_TD + "\" nowrap>" + element.getCaption() + tmp +" " +
                    element.getHeadstr();
            return header;
        }
    }


    /**
     *  Description of the Method
     *
     *@return    Description of the Return Value
     */
    protected String GetFooter() {
        String footer = element.getAfterstr() + "</td>";
        return footer;
    }


    /**
     *  Description of the Method
     *
     *@return    Description of the Return Value
     */
    public String otherStr() {
        String onClick = "";
        String onChange = "";
        String onSubmit = "";
        String readOnly = "";
        if (element.getOnclick() != null && !element.getOnclick().equals("")) {
            onClick = " onclick=\"" + element.getOnclick() + "\"";
        }

        String changeEvent = "";
        if (isChangeEvent()) {
            changeEvent = "changeFunc()";
        }
        if (element.getOnchange() != null && !element.getOnchange().equals("")) {
            onChange = " onchange=\"" + element.getOnchange() + ";" + changeEvent + "\"";
        } else if (!changeEvent.equals("")) {
            onChange = " onchange=\"" + changeEvent + "\"";
        }
        //if (isReadonly() || (!isReadonly() && element.isReadonly())) {
        if (isReadonly()) {
            readOnly = " readonly ";
        }

        String others = element.getOthers();
        String otherStr = "";
        if (others != null && !others.equals("")) {
            String other[] = others.split("\\|");
            if (other.length != 0) {
                for (int i = 0; i < other.length; i++) {
                    String[] nameAndValue = other[i].split(":");
                    if (nameAndValue.length != 2) {
                        logger.warning("Invalid name and value of " + other[i] + ",ignored! others str");
                    } else {
                        otherStr = otherStr + " " + nameAndValue[0] + "=" + "\"" + nameAndValue[1] + "\"";
                    }
                }
            }
        }
        return onClick + onChange + readOnly + otherStr;
    }


    /**
     *  Gets the ctx attribute of the AbstractFormComponent object
     *
     *@return    The ctx value
     */
    public pub.platform.form.control.SessionContext getCtx() {
        return ctx;
    }


    /**
     *  Sets the ctx attribute of the AbstractFormComponent object
     *
     *@param  ctx  The new ctx value
     */
    public void setCtx(pub.platform.form.control.SessionContext ctx) {
        this.ctx = ctx;
    }


    /**
     *  Gets the instanceId attribute of the AbstractFormComponent object
     *
     *@return    The instanceId value
     */
    public String getInstanceId() {
        return instanceId;
    }


    /**
     *  Sets the instanceId attribute of the AbstractFormComponent object
     *
     *@param  instanceId  The new instanceId value
     */
    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }


    /**
     *  Gets the changeEvent attribute of the AbstractFormComponent object
     *
     *@return    The changeEvent value
     */
    public boolean isChangeEvent() {
        return changeEvent;
    }


    /**
     *  Sets the changeEvent attribute of the AbstractFormComponent object
     *
     *@param  changeEvent  The new changeEvent value
     */
    public void setChangeEvent(boolean changeEvent) {
        this.changeEvent = changeEvent;
    }
}