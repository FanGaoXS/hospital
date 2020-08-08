package cn.wqk.manager;

import cn.wqk.manager.mapper.DoctorMapper;
import cn.wqk.manager.mapper.DutyMapper;
import cn.wqk.manager.mapper.UserMapper;
import cn.wqk.manager.pojo.Duty;
import cn.wqk.manager.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ManagerApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DoctorMapper doctorMapper;
    @Autowired
    private DutyMapper dutyMapper;
    @Autowired
    private PatientService patientService;
    @Autowired
    private Duty duty;
    @Test
    void contextLoads() {
    }
}
