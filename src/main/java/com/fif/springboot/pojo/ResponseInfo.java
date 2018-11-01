package com.fif.springboot.pojo;

public class ResponseInfo {
  public ResponseInfo() {
    flag = 0;
    flagMsg = "";
    data = "";
    time = "";
  }
  
  public ResponseInfo(int flag, String flagMsg, Object data) {
    super();
    this.flag = flag;
    this.flagMsg = flagMsg;
    this.data = data;
  }
  
  public int flag;
  public String flagMsg;
  // Json数据
  public Object data;
  // 服务器时间
  public String time = "";
}
