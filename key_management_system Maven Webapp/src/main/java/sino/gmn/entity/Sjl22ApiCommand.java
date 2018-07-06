package sino.gmn.entity;

import java.util.Date;

public class Sjl22ApiCommand {
    private Integer sId;

    private String sCommand;

    private String sRequest;

    private String sResponse;

    private String sDescribe;

    private Date sUpdateTime;

    private String sUpdateUser;

    private Integer sStatus;

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getsCommand() {
        return sCommand;
    }

    public void setsCommand(String sCommand) {
        this.sCommand = sCommand == null ? null : sCommand.trim();
    }

    public String getsRequest() {
        return sRequest;
    }

    public void setsRequest(String sRequest) {
        this.sRequest = sRequest == null ? null : sRequest.trim();
    }

    public String getsResponse() {
        return sResponse;
    }

    public void setsResponse(String sResponse) {
        this.sResponse = sResponse == null ? null : sResponse.trim();
    }

    public String getsDescribe() {
        return sDescribe;
    }

    public void setsDescribe(String sDescribe) {
        this.sDescribe = sDescribe == null ? null : sDescribe.trim();
    }

    public Date getsUpdateTime() {
        return sUpdateTime;
    }

    public void setsUpdateTime(Date sUpdateTime) {
        this.sUpdateTime = sUpdateTime;
    }

    public String getsUpdateUser() {
        return sUpdateUser;
    }

    public void setsUpdateUser(String sUpdateUser) {
        this.sUpdateUser = sUpdateUser == null ? null : sUpdateUser.trim();
    }

    public Integer getsStatus() {
        return sStatus;
    }

    public void setsStatus(Integer sStatus) {
        this.sStatus = sStatus;
    }

	@Override
	public String toString() {
		return "Sjl22ApiCommand [sId=" + sId + ", sCommand=" + sCommand + ", sRequest=" + sRequest + ", sResponse="
				+ sResponse + ", sDescribe=" + sDescribe + ", sUpdateTime=" + sUpdateTime + ", sUpdateUser="
				+ sUpdateUser + ", sStatus=" + sStatus + "]";
	}
}