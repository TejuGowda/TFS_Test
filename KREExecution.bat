start cmd.exe /c
call cd /D C:\Users\locnguyen\Downloads\Katalon_Studio_Engine_Windows_64-7.8.0
call katalonc -noSplash -runMode=console -projectPath="D:\LocNguyen\KatalonTestOps\Demo Data\Demo Data.prj" -retry=0 -testSuitePath="Test Suites/SampleProject/TS1" -executionProfile="default" -browserType="Chrome" -apiKey="b2537256-1fa3-4b65-b8fc-e1cb366d5b67" --config -proxy.auth.option=NO_PROXY -proxy.system.option=NO_PROXY -proxy.system.applyToDesiredCapabilities=true