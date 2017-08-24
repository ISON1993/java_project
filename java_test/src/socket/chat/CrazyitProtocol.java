package socket.chat;

/**
 * Created by tuzhenyu on 17-8-23.
 * @author tuzhenyu
 */
public interface CrazyitProtocol {
    int PROTOCOL_LEN = 2;

    String USER_ROUND = "@@";
    String MSG_ROUND = "**";
    String PRIVATE_ROUND = "&&";

    String LOGIN_SUCCESS = "1";
    String NAME_REP = "-1";

    String SPLITE_SIGN = "@";
}
