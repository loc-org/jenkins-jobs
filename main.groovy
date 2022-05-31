pipelineJob('pipelineJob1') {
    definition {
        cps {
            script(readFileFromWorkspace('pipelineJob1.groovy'))
            sandbox()
        }
    }
}

pipelineJob('pipelineJob2') {
    definition {
        cps {
            script(readFileFromWorkspace('pipelineJob.groovy'))
            sandbox()
        }
    }
}
// /**
//  * This method is responsible for creating the Jenkins job.
//  * @param jobName jobName
//  * @param timerConfig cron expression to schedule the job
//  * @return
//  */
// def createJenkinsJob(def jobName, def timerConfig) {

//     echo "Creating the job ${jobName}"
//   // Here I'm using a shared library in the pipeline, so I have loaded my shared library here
//   // You can simply have the entire pipeline syntax here.
//     def jobDSL="@Library('yasassri@master') _\n" +
//                 "Pipeline()"
//     def flowDefinition = new org.jenkinsci.plugins.workflow.cps.CpsFlowDefinition(jobDSL, true)
//     def instance = Jenkins.instance
//     def job = new org.jenkinsci.plugins.workflow.job.WorkflowJob(instance, jobName )
//     job.definition = flowDefinition
//     job.setConcurrentBuild(false)

//   // Adding a cron configurations if cron configs are provided
//     if (timerConfig != null && timerConfig != "") {
//         hudson.triggers.TimerTrigger newCron = new hudson.triggers.TimerTrigger(timerConfig);
//         newCron.start(job, true)
//         job.addTrigger(newCron)
//     }
//   // Here I'm adding a Job property to the Job, i'm using environment inject plugin here
//     def rawYamlLocation = "http://localhost:80/text.yaml"
//     def prop = new EnvInjectJobPropertyInfo("", "KEY=${rawYamlLocation}", "",
//             "", "", false)
//     def prop2 = new org.jenkinsci.plugins.envinject.EnvInjectJobProperty(prop)
//     prop2.setOn(true)
//     prop2.setKeepBuildVariables(true)
//     prop2.setKeepJenkinsSystemVariables(true)
//     job.addProperty(prop2)
//     job.save()
//     Jenkins.instance.reload()
// }

// job('demo') {
//     steps {
//         shell('echo Hello World!')
//     }
// }

// pipelineJob('github-demo') {
//     definition {
//         cpsScm {
//             scm {
//                 git {
//                     remote {
//                         github('jenkinsci/pipeline-examples')
//                     }
//                 }
//             }
//             scriptPath('declarative-examples/simple-examples/environmentInStage.groovy')
//         }
//     }
// }