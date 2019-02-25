Name "Instalador de Gestión de Carrera 2.0"

OutFile "installer_race.exe"

InstallDir $PROGRAMFILES\Gestion_de_Carrera_2.0

# Win7 permission
RequestExecutionLevel admin

Page directory
Page instfiles

!include "MUI.nsh"
!insertmacro MUI_LANGUAGE "Spanish"

Section
  SetOutPath $INSTDIR
  writeUninstaller "$INSTDIR\uninstall.exe"
  File /r /x "script.nsi" *
  createShortCut "$DESKTOP\Gestion_de_Carrera_2.0.lnk" "$INSTDIR\PI_Ev_1.jar"
  createShortCut "$SMPROGRAMS\Gestion_de_Carrera_2.0.lnk" "$INSTDIR\PI_Ev_1.jar"

#   #SCRIPT TO CHECK IF JRE/JDK IS INSTALLED
#	Var JavaInstallationPath
#	Section "Encontrar Java"   
#		DetectTry1:
#		StrCpy $1 "SOFTWARE\JavaSoft\Java Runtime Environment"  
#		StrCpy $2 0  
#		ReadRegStr $2 HKLM "$1" "CurrentVersion"  
#		StrCmp $2 "" DetectTry2 JRE 
#		JRE:
#		ReadRegStr $5 HKLM "$1\$2" "JavaHome"  
#		StrCmp $5 "" DetectTry2 GetValue    
#
#		DetectTry2:  
#		ReadRegStr $2 HKLM "SOFTWARE\JavaSoft\Java Development Kit" "CurrentVersion"  
#		StrCmp $2 "" NoJava JDK 
#		JDK:
#		ReadRegStr $5 HKLM "SOFTWARE\JavaSoft\Java Development Kit\$2" "JavaHome"  
#		StrCmp $5 "" NoJava GetValue
#
#		GetValue:
#		StrCpy $JavaInstallationPath $5
#		Messagebox MB_OK "Java esta instalado. Su directorio es: $JavaInstallationPath"
#		Goto done
#
#		NoJava:  
#		Messagebox MB_OK "No se ha encontrado java. Instalando."  
#		# Install Java
#		ExecWait "$INSTDIR\java\instalador_java.exe"
#		Goto DetectTry1
#
#		done:   
#		#$JavaInstallationPath esta la ruta a java
#       RMDir /r /REBOOTOK "$INSTDIR\java"
#	SectionEnd 
  


SectionEnd

section "uninstall"
    delete "$SMPROGRAMS\Gestion_de_Carrera_2.0.lnk"
    delete "$DESKTOP\Gestion_de_Carrera_2.0.lnk"
    RMDir /r /REBOOTOK $INSTDIR
sectionEnd
