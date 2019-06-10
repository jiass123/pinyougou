package com.pinyougou;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActTest {

    @Autowired
    private ProcessEngineConfiguration processEngineConfiguration;

    ProcessEngine processEngine ;

    @Before
    public void init(){
        processEngine = processEngineConfiguration.buildProcessEngine();

    }


    @Test
    public void createActDB1(){
        // 创建单例流程引擎配置对象
        ProcessEngineConfiguration processEngineConfiguration
                = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();

        // 设置数据库配置
        processEngineConfiguration.setJdbcDriver("com.mysql.jdbc.Driver");
        processEngineConfiguration.setJdbcUsername("root");
        processEngineConfiguration.setJdbcPassword("123");
        processEngineConfiguration.setJdbcUrl("jdbc:mysql://localhost:3306/activit?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8");

        // 设置当数据库表不存在时 进行创建
        processEngineConfiguration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);

        // 创建流程引擎对象
        ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
        processEngine.getRepositoryService().createDeployment().name("helloworld").addClasspathResource("bpmn/helloWorld.bpmn").deploy();
        System.out.println(processEngine);
    }

    @Test
    public void createActDB2(){
        ProcessEngine processEngine = processEngineConfiguration.buildProcessEngine();
        System.out.println(processEngine);
    }

    /**
     * 部署流程定义
     */
    @Test
    public void deploy(){

        // 通过流程引擎创建部署对象
        Deployment deployment = processEngine.getRepositoryService().createDeployment()

                // 设置部署对象名称
                .name("helloWorld入门程序")
                // 设置部署资源路径
                .addClasspathResource("bpmn/helloWorld.bpmn")
                // 开始部署
                .deploy();
        System.out.println(deployment.getId());
        System.out.println(deployment.getName());

    }

    /**
     * 启动流程实例
     */
    @Test
    public void run(){

        // 获取流程服务
        ProcessInstance instance = processEngine.getRuntimeService()

                // 通过流程定义的id 启动流程实例（最新版本）
                .startProcessInstanceByKey("helloworld");
        System.out.println(instance.getId());
        System.out.println(instance.getName());
    }

    /**
     * 查询任务办理人
     */
    @Test
    public void findTask(){
        // 获取任务查询对象
        List<Task> tasks = processEngine.getTaskService()
                // 创建任务查询
                .createTaskQuery()
                // 设置任务受理人
                .taskAssignee("王五")
                // 查询列表
                .list();
        for (Task task : tasks){

            // 任务id
            System.out.println(task.getId());

            // 任务名称
            System.out.println(task.getName());

            // 任务创建时间
            System.out.println(task.getCreateTime());

            // 任务受理人
            System.out.println(task.getAssignee());

            // 流程实例id
            System.out.println(task.getProcessInstanceId());

            // 执行id
            System.out.println(task.getExecutionId());

            // 流程定义id
            System.out.println(task.getProcessDefinitionId());
        }
    }

    /**
     * 完成任务
     */
    @Test
    public void complete(){
        processEngine.getTaskService().complete("7502");
    }

    /**
     * 查询流程定义信息
     */
//    @Test
//    public void findProcessDefind(){
//
//        // 创建流程定义查询
//        processEngine.getRepositoryService().createProcessDefinitionQuery()
//
//                /**======查询条件======**/
//                // 使用部署id进行查询
//                .deploymentId()
//
//                // 使用流程定义id查询
//                .processDefinitionId()
//
//                // 使用流程定义key查询
//                .processDefinitionKey()
//
//                // 使用流程定义名称模糊查询
//                .processDefinitionNameLike()
//
//                /**======排序条件======**/
//                // 根据流程定义版本进行排序
//                .orderByProcessDefinitionVersion().asc()
//
//                // 根据流程定义名称进行排序
//                .orderByProcessDefinitionName().desc()
//
//                /**======排序条件======**/
//
//
//    }
}
