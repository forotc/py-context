package com.ailu.pycontext.dao.mapper.ext;

import com.ailu.pycontext.dao.bean.AllMsg;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:
 * @author: liu zhenming
 * @version: V1.0
 * @date: 2018/5/25 16:27
 */
@Repository("allMsgExt")
public interface AllMsgExt {

    @Select("SELECT * FROM all_msg ORDER BY ctime DESC")
    List<AllMsg> getMsgExt();

}
