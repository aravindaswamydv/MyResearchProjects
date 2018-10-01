#include <MsgBoxConstants.au3>
Local $BrowserName=$CmdLine[1] ; Variable to hold the value sent for browser name from command line argument 1
Local $UploadFilePath=$CmdLine[2] ; Variable to hold the value sent for uploadfilePath from command line argument 2
Local $UploadWindowTitle ; variable to hold the upload window title

; Set the upload window title based on browser type
if $BrowserName = "GC" Then
	$UploadWindowTitle = "Open"
ElseIf $BrowserName = "FF" Then
	$UploadWindowTitle = "File Upload"
	Else
	$UploadWindowTitle = "Choose File to Upload"
EndIf
WinActivate($UploadWindowTitle)
WinWaitActive($UploadWindowTitle)
Send($UploadFilePath)
Send("{ENTER}")
;MsgBox($MB_SYSTEMMODAL,"Hello browser ", $BrowserName & "  " & $UploadWindowTitle & " filepath :  " & $UploadFilePath)