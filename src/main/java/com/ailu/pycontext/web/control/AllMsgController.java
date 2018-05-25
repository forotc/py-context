package com.ailu.pycontext.web.control;

import com.ailu.pycontext.dao.bean.AllMsgExample;
import com.ailu.pycontext.dao.mapper.AllMsgMapper;
import com.ailu.pycontext.dao.mapper.ext.AllMsgExt;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description:
 * @author: liu zhenming
 * @version: V1.0
 * @date: 2018/5/25 16:07
 */
@Slf4j
@RestController
@RequestMapping(path = "/query", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AllMsgController {

    @Resource
    AllMsgMapper allMsgMapper;

    @Resource
    AllMsgExt allMsgExt;


    @GetMapping("/all/type/{msgType}")
    public String quetyAllTypeData(@PathVariable String msgType) {
        AllMsgExample example = new AllMsgExample();
        example.or().andTypeEqualTo(msgType);
        return jsonChange(allMsgMapper.selectByExample(example));
    }

    @GetMapping("/all")
    public String queryAll() {
        return JSONObject.toJSONString(allMsgExt.getMsgExt());

    }

    private String jsonChange(Object object) {
        return JSONObject.toJSONString(object);
    }

}
