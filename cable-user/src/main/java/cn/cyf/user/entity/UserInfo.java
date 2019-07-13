package cn.cyf.user.entity;

import cn.cyf.common.json.LongToDateSerialize;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.toolkit.IdWorker;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName("sys_user")
public class UserInfo implements Serializable {

    private static final long serialVersionUID = -1489801037735850087L;
    @TableId(type = IdType.UUID)
    private String id;
    private String username;
    private String password;
    private String nickname;
    @TableField("is_lock")
    private Integer isLock;
    @TableField("delete_status")
    private Integer deleteStatus;
    @TableField("create_time")
    @JSONField(serializeUsing = LongToDateSerialize.class)
    private Date createTime;

    @JSONField(serializeUsing = LongToDateSerialize.class)
    @TableField("update_time")
    private Date updateTime;
    @TableField("role_id")
    private String roleId;
    @TableField("last_login_time")
    private Date lastLoginTime;
    private String phone;
    private String email;
    private transient RoleInfo roleInfo;
    private transient List<String> menuList;
    private transient List<String> permissionList;
}
