/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package InfoBean;

/**
 *
 * @author ishanp
 */
public class InputUserInfo {
        private String fromDate;
        private String toDate;
        private String consultantIp;
        private String consultantIPOperator;
        private String top;
        private String ConsultantName;
        private String consultantNameOperator;
        private String reportType;
        private String urlKeyword;
        private String urlKeywordOperator;
        private String removekeyword;
        private String fromTime;
        private String toTime;
        private String viewerType;
        private String filepath;
        private String username;
        private String password;
        private boolean flag;
        private String orderby;
        private String orderbyvalue;

    public String getOrderbyvalue() {
        return orderbyvalue;
    }

    public void setOrderbyvalue(String orderbyvalue) {
        this.orderbyvalue = orderbyvalue;
    }
        
        

    public String getOrderby() {
        return orderby;
    }

    public void setOrderby(String orderby) {
        this.orderby = orderby;
    }
     

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if(username.equals("")) setFlag(false);
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(password.equals("")) setFlag(false);
        this.password = password;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getViewerType() {
        return viewerType;
    }

    public void setViewerType(String viewerType) {
        this.viewerType = viewerType;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getFromTime() {
        return fromTime;
    }

    public void setFromTime(String fromTime) {
        try{
        String[] values=fromTime.split(":");
        String HH=values[0];
        String MM=values[1];
        String SS=values[2];    
        if(values[0].equals("HH")||values[0].trim().equals(""))
        { HH="00"; }
        else {
           if(Integer.parseInt(values[0])<0 || Integer.parseInt(values[0])>23) HH="00";
           HH=String.format("%02d",Integer.parseInt(values[0]));
        }
        if(values[1].equals("MM")||values[1].trim().equals(""))
        { MM="00"; }
        else{
            if(Integer.parseInt(values[1])<0 || Integer.parseInt(values[1])>59) MM="00";
            MM=String.format("%02d",Integer.parseInt(values[1]));
        }
        if(values[2].equals("SS")||values[2].trim().equals(""))
        { SS="00"; }
        else{
            if(Integer.parseInt(values[2])<0 || Integer.parseInt(values[2])>59) SS="00";
            SS=String.format("%02d",Integer.parseInt(values[2]));
        }
        this.fromTime=HH+":"+MM+":"+SS;
        }catch(Exception e){
        this.fromTime = "00:00:00";
        }
    }

    public String getToTime() {
        return toTime;
    }

    public void setToTime(String toTime) {
        try{
        String[] values=toTime.split(":");
        String HH=values[0];
        String MM=values[1];
        String SS=values[2];    
        if(values[0].equals("HH")||values[0].trim().equals(""))
        { HH="23"; }
        else {
           if(Integer.parseInt(values[0])<0 || Integer.parseInt(values[0])>23) HH="23";
           HH=String.format("%02d",Integer.parseInt(values[0]));
        }
        if(values[1].equals("MM")||values[1].trim().equals(""))
        { MM="59"; }
        else{
            if(Integer.parseInt(values[1])<0 || Integer.parseInt(values[1])>59) MM="59";
            MM=String.format("%02d",Integer.parseInt(values[1]));
        }
        if(values[2].equals("SS")||values[2].trim().equals(""))
        { SS="59"; }
        else{
            if(Integer.parseInt(values[2])<0 || Integer.parseInt(values[2])>59) SS="59";
            SS=String.format("%02d",Integer.parseInt(values[2]));
        }
        this.toTime=HH+":"+MM+":"+SS;
        }catch(Exception e){
        this.toTime = "23:59:59";
        }
    }

    public String getRemovekeywordOperator() {
        return removekeywordOperator;
    }

    public void setRemovekeywordOperator(String removekeywordOperator) {
        this.removekeywordOperator = removekeywordOperator;
    }
        private String removekeywordOperator;

    public String getFromDate() {
        return fromDate;
    }

    public String getConsultantIPOperator() {
        return consultantIPOperator;
    }

    public void setConsultantIPOperator(String consultantIPOperator) {
        this.consultantIPOperator = consultantIPOperator;
    }

    public String getConsultantNameOperator() {
        return consultantNameOperator;
    }

    public void setConsultantNameOperator(String consultantNameOperator) {
        this.consultantNameOperator = consultantNameOperator;
    }

    public String getUrlKeywordOperator() {
        return urlKeywordOperator;
    }

    public void setUrlKeywordOperator(String urlKeywordOperator) {
        this.urlKeywordOperator = urlKeywordOperator;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getConsultantIp() {
        return consultantIp;
    }

    public void setConsultantIp(String consultantIp) {
        this.consultantIp = consultantIp;
    }

    public String getTop() {
        return top;
    }

    public void setTop(String top) {
        this.top = top;
    }

    public String getConsultantName() {
        return ConsultantName;
    }

    public void setConsultantName(String ConsultantName) {
        this.ConsultantName = ConsultantName;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getUrlKeyword() {
        return urlKeyword;
    }

    public void setUrlKeyword(String urlKeyword) {
        this.urlKeyword = urlKeyword;
    }

    public String getRemovekeyword() {
        return removekeyword;
    }

    public void setRemovekeyword(String removekeyword) {
        this.removekeyword = removekeyword;
    }

    @Override
    public String toString() {
        return "InputUserInfo{" + "fromDate=" + fromDate + ", toDate=" + toDate + ", consultantIp=" + consultantIp + ", consultantIPOperator=" + consultantIPOperator + ", top=" + top + ", ConsultantName=" + ConsultantName + ", consultantNameOperator=" + consultantNameOperator + ", reportType=" + reportType + ", urlKeyword=" + urlKeyword + ", urlKeywordOperator=" + urlKeywordOperator + ", removekeyword=" + removekeyword + '}';
    }
  
}
