package com.tangv.demo.ThreadLocal;

import com.tangv.demo.elasticSearch.MoEsLog;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/6/12 4:09 下午
 */
@RestController
public class ThreadLocalController {

    @PostMapping("/setThreadLocal")
    public MoEsLog set() {
        ThreadLocal<MoEsLog> threadLocal = new ThreadLocal<>();
        MoEsLog moEsLog = new MoEsLog();
        moEsLog.setId("wew");
        moEsLog.setDateTime("edfv");
        moEsLog.setMessage("你猜猜看鸭");
        threadLocal.set(moEsLog);
        MoEsLog moEsLogs = threadLocal.get();
        return moEsLogs;
    }

    @PostMapping("/getThreadLocal")
    public MoEsLog get() {
        ThreadLocal<MoEsLog> threadLocal = new ThreadLocal<>();
        MoEsLog moEsLog = threadLocal.get();
        return moEsLog;
    }

}
