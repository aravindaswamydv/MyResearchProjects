#include <MsgBoxConstants.au3>
Local $BrowserName=$CmdLine[1] ; Variable to hold the value sent for browser name from command line argument 1
Local $UploadFilePath=$CmdLine[2] ; Variable to hold the value sent for uploadfilePath from command line argument 2
Local $UploadWindowTitle ; variable to hold the upload window title

; Set the pop up window title based on browser type
if $BrowserName = "GC" Then
	$UploadWindowTitle = "Open"
ElseIf $BrowserName = "FF" Then
	$UploadWindowTitle = "File Upload"
	Else
	$UploadWindowTitle = "Choose File to Upload"
 EndIf
Opt("WinTitleMatchMode", 3) ; set the mode for Exact title match
 If WinExists($UploadWindowTitle) Then
        ;MsgBox($MB_SYSTEMMODAL, "", "Window exists")
		WinActivate($UploadWindowTitle)
		Send($UploadFilePath)
		Send("{ENTER}")
		Exit(1) ; set the exit value to 1 so that the given value is returned to calling program to decide this piece of code is executed
    Else
        ;MsgBox($MB_SYSTEMMODAL + $MB_ICONERROR, "Error", "Window does not exist")
		Exit(2) ; set the exit value to 2 so that the given value is returned to calling program to decide this piece of code is executed
    EndIf