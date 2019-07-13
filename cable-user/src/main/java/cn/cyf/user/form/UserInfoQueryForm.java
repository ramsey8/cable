package cn.cyf.user.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoQueryForm implements Serializable {

    private static final long serialVersionUID = 7591554969438609507L;
    protected String nickname;
    protected String id;
    private int pageNum = 1;
    private int pageRow = 10;
    private String phone;
    private String email;
}
