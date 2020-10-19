import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.configuration.RunConfiguration


CustomKeywords.'sample.Common.findUserById'(7, 25, 'mimi', '123456789', 'MALE', 200)

CustomKeywords.'utilHelper.IOHelper.createFileWithData'(RunConfiguration.getReportFolder().toString())