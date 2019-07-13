package cn.cyf.user.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoUpdateForm extends UserInfoQueryForm {

    private Integer deleteStatus;
    private String password;
    private String roleId;
    private String username;
    private Integer isLock;
}
