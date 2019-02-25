Name "Instalador de Gestión de Avituallamiento 2.0"

OutFile "installer_supply.exe"

InstallDir $PROGRAMFILES\Gestion_de_Avituallamiento_2.0

# Win7 permission
RequestExecutionLevel admin

Page directory
Page instfiles

!include "MUI.nsh"
!insertmacro MUI_LANGUAGE "Spanish"

Section
  SetOutPath $INSTDIR
  writeUninstaller "$INSTDIR\uninstall.exe"
  File "PI_Ev_2.exe"
  createShortCut "$DESKTOP\Gestion_de_Avituallamiento_2.0.lnk" "$INSTDIR\PI_Ev_2.exe"
  createShortCut "$SMPROGRAMS\Gestion_de_Avituallamiento_2.0.lnk" "$INSTDIR\PI_Ev_2.exe"
SectionEnd

section "uninstall"
    delete "$SMPROGRAMS\Gestion_de_Avituallamiento_2.0.lnk"
    delete "$DESKTOP\Gestion_de_Avituallamiento_2.0.lnk"
    RMDir /r /REBOOTOK $INSTDIR
sectionEnd
