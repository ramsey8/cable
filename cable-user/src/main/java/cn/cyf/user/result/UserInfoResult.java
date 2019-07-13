package cn.cyf.user.result;

import cn.cyf.common.json.LongToDateSerialize;
import cn.cyf.user.entity.RoleInfo;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserInfoResult implements Serializable {

    private static final long serialVersionUID = 5125312971054480355L;
    private String id;
    private String username;
    private String password;
    private String nickname;
//    private Integer isLock;
    private Integer deleteStatus;
    @JSONField(serializeUsing = LongToDateSerialize.class)
    private Date createTime;

    @JSONField(serializeUsing = LongToDateSerialize.class)
    private Date updateTime;

    private Integer isLock;

    private RoleInfo roleInfo;
    private List<String> menuList;
    private List<String> permissionList;
    @JSONField(serializeUsing = LongToDateSerialize.class)
    private Date lastLoginTime;
    private String phone;
    private String email;

}
