package cn.cyf.user.service.impl;

import cn.cyf.user.entity.RoleInfo;
import cn.cyf.user.mapper.RoleInfoMapper;
import cn.cyf.user.service.RoleInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class RoleInfoServiceImpl extends ServiceImpl<RoleInfoMapper, RoleInfo> implements RoleInfoService {
}
