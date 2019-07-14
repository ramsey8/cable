package cn.cyf.user.service.impl;

import cn.cyf.common.ResponseData;
import cn.cyf.user.entity.UserInfo;
import cn.cyf.user.form.UserInfoUpdateForm;
import cn.cyf.user.mapper.UserMapper;
import cn.cyf.user.result.UserInfoResult;
import cn.cyf.user.service.UserInfoService;
import cn.cyf.user.shiro.ShiroMd5Util;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl extends ServiceImpl<UserMapper, UserInfo> implements UserInfoService {


    @Override
    public Page<UserInfoResult> selectUserListPage(UserInfo userInfo, int pageNum, int pageRow) {
        Page<UserInfoResult> page = new Page<>(pageNum, pageRow, "updateTime", false);
        return page.setRecords(this.baseMapper.selectUserListPage(page, userInfo));
    }

    /**
     * 编辑账户
     * @param form
     * @return
     */
    @Override
    public ResponseData updateUser(UserInfoUpdateForm form) {

        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(form, userInfo);
        if (StringUtils.isNotBlank(form.getPassword())) {
            userInfo.setPassword(ShiroMd5Util.encrypt(userInfo.getUsername(), userInfo.getPassword()));
        }
        this.insertOrUpdate(userInfo);
        return ResponseData.ok();
    }

}
