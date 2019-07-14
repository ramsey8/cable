package cn.cyf.user.result;

import cn.cyf.common.json.LongToDateSerialize;
import cn.cyf.user.entity.PermissionInfo;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class RoleInfoResult {

    private String id;
    private String roleName;
    private transient List<PermissionInfo> permissionInfoList;
    //    private Integer isLock;
    private Integer deleteStatus;

    @JSONField(serializeUsing = LongToDateSerialize.class)
    private Date createTime;

    @JSONField(serializeUsing = LongToDateSerialize.class)
    private Date updateTime;
    private List<PermissionInfoResult> menus;
}
