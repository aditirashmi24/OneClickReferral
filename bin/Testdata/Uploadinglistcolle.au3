WinWait("[CLASS:#32770]","",20)
;Set input focus to the edit control of Upload window using the handle returned by WinWait

ControlFocus("Open","","Edit1")

Sleep(3000)

;Set the file name on the edit filed

ControlSetText("Open","","Edit1","D:\Vivek_Workspace\OncClickReferral\Testdata\UploadingListColleagues.xls")

Sleep(3000)

;click on the open button

ControlClick("Open","","Button1")