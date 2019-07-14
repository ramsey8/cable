package cn.cyf.user.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleInfoQueryForm {

    private int pageNum;
    private int pageRow;
}
