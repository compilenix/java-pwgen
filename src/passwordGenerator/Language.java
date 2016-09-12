package passwordGenerator;

/**
 * to set/get the displayed language.<br/>
 * 
 * @version 2012.09.30
 * @author Kevin Weis
 */
public class Language {
	/**
	 * - ENG<br/>
	 * - GER<br/>
	 * 
	 * @param Language (as int) set the language you want to use.
	 */
	public Language(int Language) {
		switch (Language) {
		case ENGLISH:
			setLanguage(ENGLISH);
			break;
		case GERMAN:
			setLanguage(GERMAN);
			break;
		default:
			setLanguage(ENGLISH);
			break;
		}
	}

	/**
	 * @see Language
	 * @param language (as String) the 3 char log alias of the language you want to set.<br/>
	 */
	public void setLanguage(int language) {
		switch (language) {
		case ENGLISH:
			CURRENT_LANG = ENGLISH;
			ButtonCancel = "Cancel";
			ButtonClear = "Clear";
			ButtonExport = "Export";
			ButtonExportPopupMenuItemAsCsv = "As CSV (UTF-8)";
			ButtonExportPopupMenuItemAsText = "As Text (UTF-8)";
			ButtonDeleteSelected = "Delete Selected Element(s)";
			ButtonGenerate = "Generate";
			ButtonImport = "Import";
			ButtonSelectAll = "Select All";
			ButtonWindowToolsMultiHashCalculate = "Calculcate";
			ButtonWindowToolsMultiHashClear = "Clear";
			CheckBoxNumbers = "Numbers";
			CheckBoxSpezial = "Special";
			HintButtonClear = "Reset table!";
			HintButtonExport = "Export all elements from the table into a text file (UTF-8)";
			HintButtonImport = "Import all elements from a text file (UTF-8) into the table";
			HintButtonGenerate = "Generate...";
			HintCheckBoxLowerCase = "Includes characters from \"a\" to \"z\" (lowercase)";
			HintCheckBoxNumbers = "Includes Numbers from \"0\" to \"9\"";
			HintCheckBoxSpecial = "Includes spezial characters (!\"#$%&'()*+,-./:;<=>?@)";
			HintCheckBoxUpperCase = "Includes characters from \"A\" to \"Z\" (UPPERCASE)";
			HintRadioButtonGeneratePassword = "Generate random password(s)";
			HintRadioButtonOwnPW = "Add the password to the list and optional a hash of it";
			HintSlider = "Set length of generated password";
			HintTextFieldEnterOwnPW = "Type a password";
			LabelWait = "Please wait!";
			MenuBarViewChangeLanguage = "Change Language";
			MenuBarViewChangeLanguageEN = "English";
			MenuBarViewChangeLanguageGER = "German";
			MenuBarFile = "File";
			MenuBarFileExit = "Exit";
			MenuBarFileExport = ButtonExport + "...";
			MenuBarFileImport = ButtonImport + "...";
			MenuBarHelp = "Help";
			MenuBarHelpAbout = "About";
			MenuBarHelpCommandline = "Commandline";
			MenuBarHelpCheckUpdate = "Check for updates";
			MenuBarHelpNews = "News";
			MenuBarView = "View";
			MenuBarViewWindowStyle = "Window-Style";
			MenuBarTools = "Tools";
			MenuBarToolsMultiHash = "Multi Hash";
			MessageFileWritten_Part1 = "Data has been written at: ";
			MessageFileWritten_Part2 = "";
			MessageCantConnectToServer = "Can not connect to server, please verify your internet connection!";
			MessageFileExists = "The file already exists... you want to overwrite it?\nchoosing no, appand it.";
			MessageFileExistsTitle = "Save";
			MessageImportGenerateHash = "You want to generate a hash of what you import?";
			MessageImportGenerateHashTitle = "Generate hash(s)";
			MessageNegativeCount = "Oh... you choosen a negative count ... I set it for you back to posetive";
			MessageNegativeCountTitle = "Negative count!";
			MessageUpdateNeedToUpdate = "Please update your version!!!\n\nYour version is:\n" + Main.version + "\nNew version is:\n"
					+ Main.newVersion + "\n\ndo you want to download the last version?";
			MessageUpdateNeedToUpdateTitle = "Check for update";
			MessageUpdateUpToDate = "Your version is up to date, no need to update...";
			MessageUpdateUpToDateTitle = "Check for Update...";
			MessageToMuchPasswords = "Oh... you choosen too much Passwords... I set it for you back to 2.000.000";
			MessageToMuchPasswordsTitle = "Tooooooo much passwords!";
			MessageToMuchOverAllPasswords = "Oh... too much Passwords.\nWould you add much more passwords the JAVA VM could be realy Laggy!";
			MessageToMuchOverAllPasswordsTitle = "Too much...";
			MessageZero = "Oh... you choosen... zero. I set it for you back to 1";
			MessageZeroTitle = "Zero count!";
			PasswordCounter = "Password count";
			RadioButtonGeneratePassword = "Gen. Password";
			TablePassword = "Password";
			TablePopupMenuItemCopy = "Copy";
			WindowAboutAuthor = "Author";
			WindowAboutHomepage = "Homepage";
			WindowAboutTitle = "About";
			WindowAboutOKButton = "Don`t hit me!";
			WindowNewsHomepage = "Homepage";
			WindowNewsTitle = "News";
			WindowNewsButtonPointless = "Pointless Button";
			WindowToolsMultiHashResult = "Result";
			break;
		case GERMAN:
			CURRENT_LANG = GERMAN;
			ButtonCancel = "Abbrechen";
			ButtonClear = "Leeren";
			ButtonDeleteSelected = "Entferne selektierte Einträge";
			ButtonExport = "Exportieren";
			ButtonExportPopupMenuItemAsCsv = "Als CSV (UTF-8)";
			ButtonExportPopupMenuItemAsText = "Als Text (UTF-8)";
			ButtonGenerate = "Erstellen";
			ButtonImport = "Importieren";
			ButtonSelectAll = "Alle Einträge auswählen";
			ButtonWindowToolsMultiHashCalculate = "Berechne";
			ButtonWindowToolsMultiHashClear = "Leeren";
			CheckBoxNumbers = "Zahlen";
			CheckBoxSpezial = "Spezial";
			HintButtonClear = "Tabelle zurücksetzen!";
			HintButtonExport = "Exportiere alle Elemente der Tabelle in eine Textdatei (UTF-8)";
			HintButtonImport = "Importiere alle Elemente einer Textdatei (UTF-8) in die Tabelle";
			HintButtonGenerate = "Generieren...";
			HintCheckBoxLowerCase = "Beinhaltet alle Zeichen von \"a\" bis \"z\" (Kleinbuchstaben)";
			HintCheckBoxNumbers = "Beinhaltet alle Zeichen von \"0\" bis \"9\"";
			HintCheckBoxSpecial = "Beinhaltet einige Sonderzeichen (!\"#$%&'()*+,-./:;<=>?@)";
			HintCheckBoxUpperCase = "Beinhaltet alle Zeichen von \"A\" bis \"Z\" (Großbuchstaben)";
			HintRadioButtonGeneratePassword = "Generiere zufällige Passworte";
			HintRadioButtonOwnPW = "Füge eigene Passworte der Tabelle hinzu (optional mit Prüfsumme)";
			HintSlider = "Lege fest wieviele Zeichen lang jedes generierte Passwort sein soll";
			HintTextFieldEnterOwnPW = "Tippe hier dein eigenes Passwort";
			LabelWait = "Bitte warten!";
			MenuBarViewChangeLanguage = "Sprache ädern";
			MenuBarViewChangeLanguageEN = "Englisch";
			MenuBarViewChangeLanguageGER = "Deutsch";
			MenuBarFile = "Datei";
			MenuBarFileExit = "Beenden";
			MenuBarFileExport = ButtonExport + "...";
			MenuBarFileImport = ButtonImport + "...";
			MenuBarHelp = "Hilfe";
			MenuBarHelpAbout = "Über";
			MenuBarHelpCommandline = "Kommandozeile";
			MenuBarHelpCheckUpdate = "Prüfe auf Updates";
			MenuBarHelpNews = "Neues";
			MenuBarView = "Ansicht";
			MenuBarViewWindowStyle = "Fenster-Design";
			MenuBarTools = "Tools";
			MenuBarToolsMultiHash = "Multi Hash";
			MessageFileWritten_Part1 = "Daten wurden fertig nach: ";
			MessageFileWritten_Part2 = " geschrieben.";
			MessageCantConnectToServer = "Es kann keine Verbindung zu dem Server hergestellt werden,\nbitte überprüfen sie Ihre Internetverbindung";
			MessageFileExists = "Die gewählte Datei existiert bereits... wollen Sie diese überschreiben?\nWenn Sie \"nein\" wählen wird die Datei erweitert.";
			MessageFileExistsTitle = "Speichern";
			MessageImportGenerateHash = "Wollen Sie auch Prüfsummen der importieren Passworte generieren lassen?";
			MessageImportGenerateHashTitle = "Prüfsummen generieren";
			MessageNegativeCount = "Ohh... Sie haben einen negativen Wert der zu generierenden Passwörter gewählt...\nIch werde für Sie den Wert invertiert setzen";
			MessageNegativeCountTitle = "Negativer Wert!";
			MessageUpdateNeedToUpdate = "Bitte Speichere die Neue Version dieses Programmes!!!\n\nIhre momentane Version ist:\n" + Main.version
					+ "\nDie Neue Version ist:\n" + Main.newVersion + "\n\nWollen Sie die neue Version herunterladen?";
			MessageUpdateNeedToUpdateTitle = "Check for update";
			MessageUpdateUpToDate = "Deine Version dieses Programmes ist bereis aktuell, ein Update ist nicht erforderlich...";
			MessageUpdateUpToDateTitle = "Prüfe auf Updates...";
			MessageToMuchPasswords = "Ohh... Sie haben zuu viele zu generierende Passworte gewählt... Ich setze den Wert für Sie auf das Maximun (2.000.000)";
			MessageToMuchPasswordsTitle = "Zuuuuuuuuu viele Passworte!";
			MessageToMuchOverAllPasswords = "Ohh... zuu viele Passwörter.\nWürden Sie noch mehr Passwörte der hunzufügen könnte die JAVA VM evtl. instabil werden!";
			MessageToMuchOverAllPasswordsTitle = "Zuu viele...";
			MessageZero = "Ohh... Ihre Wahl ist... Null./n/nIch setze den Wert für Sie wieder auf 1";
			MessageZeroTitle = "Zero count!";
			PasswordCounter = "Anzahl Passworte";
			RadioButtonGeneratePassword = "Gen. Passwort";
			TablePassword = "Passwort";
			TablePopupMenuItemCopy = "Kopieren";
			WindowAboutAuthor = "Entwickler";
			WindowAboutHomepage = "Webseite";
			WindowAboutTitle = "Über";
			WindowAboutOKButton = "Ja, amen!";
			WindowNewsHomepage = "Webseite";
			WindowNewsTitle = "Neues";
			WindowNewsButtonPointless = "Sinnloser Knopf";
			WindowToolsMultiHashResult = "Ergebnis";
			break;
		default:
			break;
		}
	}

	/**
	 * holds (as int) the current language
	 */
	public static int CURRENT_LANG = -1;
	/**
	 * holds (as int) the default language English
	 */
	public static final int ENGLISH = 0;
	/**
	 * holds (as int) the default language German
	 */
	public static final int GERMAN = 1;
	/**
	 * holds (as int) the default language user loaded language
	 */
	public static final int LOADED_LANG = -2;
	/**
	 * Text from the cancel button (while the user generate passwords)
	 */
	public String ButtonCancel;
	/**
	 * Text from the clear button below the GenerateButton/CancelButton
	 */
	public String ButtonClear;
	/**
	 * Text from the ExportButton
	 */
	public String ButtonExport;
	/**
	 * Text from the context menu button export as CSV (UTF-8)
	 */
	public String ButtonExportPopupMenuItemAsCsv;
	/**
	 * Text from the context menu button export as Text (UTF-8)
	 */
	public String ButtonExportPopupMenuItemAsText;
	/**
	 * Text from the Generate button
	 */
	public String ButtonGenerate;
	/**
	 * Text from the import button (not jet been aktivated)
	 */
	public String ButtonImport;
	/**
	 * Title from the Checkbox Numbers (0 to 9)
	 */
	public String CheckBoxNumbers;
	/**
	 * Title from the Checkbox Special chars (!\"#$%&'()*+,-./:;<=>?@)
	 */
	public String CheckBoxSpezial;
	/**
	 * Text from the Hint of the ClearButton
	 */
	public String HintButtonClear;
	/**
	 * Text from the Hint of the DeleteSelectedButton
	 */
	public String ButtonDeleteSelected;
	/**
	 * Text from the Hint of the ExportButton
	 */
	public String HintButtonExport;
	/**
	 * Text from the Hint of the ExportButton
	 */
	public String HintButtonImport;
	/**
	 * Text from the Hint of the GenerateButton
	 */
	public String HintButtonGenerate;
	/**
	 * Text from the Hint of the SelectAllButton
	 */
	public String ButtonSelectAll;
	/**
	 * Text from the Calculate button at the Multi Hash Window
	 */
	public String ButtonWindowToolsMultiHashCalculate;
	/**
	 * Text from the Clear button at the Multi Hash Window
	 */
	public String ButtonWindowToolsMultiHashClear;
	/**
	 * Text from the Hint of the LowercaseCheckBox
	 */
	public String HintCheckBoxLowerCase;
	/**
	 * Text from the Hint of the NumbersCheckBox
	 */
	public String HintCheckBoxNumbers;
	/**
	 * Text from the Hint of the SpecialCheckBox
	 */
	public String HintCheckBoxSpecial;
	/**
	 * Text from the Hint of the UpperCaseCheckBox
	 */
	public String HintCheckBoxUpperCase;
	/**
	 * Text from the Hint of the Gen.PWRadioButton
	 */
	public String HintRadioButtonGeneratePassword;
	/**
	 * Text from the Hint of the AddOwnPWRadioButton
	 */
	public String HintRadioButtonOwnPW;
	/**
	 * Text from the Hint of the Slider (Password length)
	 */
	public String HintSlider;
	/**
	 * Text from the Hint of the TextField (to enter own PW)
	 */
	public String HintTextFieldEnterOwnPW;
	/**
	 * Text from the Label ("Please wait!")
	 */
	public String LabelWait;
	/**
	 * Text from the Menu Bar File
	 */
	public String MenuBarFile;
	/**
	 * Text from the Menu Bar File Exit
	 */
	public String MenuBarFileExit;
	/**
	 * Text from the Menu Bar File Export
	 */
	public String MenuBarFileImport;
	/**
	 * Text from the Menu Bar File Export
	 */
	public String MenuBarFileExport;
	/**
	 * Text from the Menu Bar Help
	 */
	public String MenuBarHelp;
	/**
	 * Text from the Menu Bar Help About
	 */
	public String MenuBarHelpAbout;
	/**
	 * Text from the Menu Bar Help commandline
	 */
	public String MenuBarHelpCommandline;
	/**
	 * Text from the Menu Bar Check for Updates
	 */
	public String MenuBarHelpCheckUpdate;
	/**
	 * Text from the Menu Bar Help News
	 */
	public String MenuBarHelpNews;
	/**
	 * Text from the Menu Bar View
	 */
	public String MenuBarView;
	/**
	 * Text from the Menu Bar Edit Change Language
	 */
	public String MenuBarViewChangeLanguage;
	/**
	 * Text from the Menu Bar Change Language English
	 */
	public String MenuBarViewChangeLanguageEN;
	/**
	 * Text from the Menu Bar Change Language German
	 */
	public String MenuBarViewChangeLanguageGER;
	/**
	 * Text from the Menu Bar View Window Style
	 */
	public String MenuBarViewWindowStyle;
	/**
	 * Text from the Menu Bar View Tools
	 */
	public String MenuBarTools;
	/**
	 * Text from the Menu Bar View Tools Multihash
	 */
	public String MenuBarToolsMultiHash;
	/**
	 * Text from the MessageDialog file was written to... Part one<br>
	 * This Part should followed by the filename.
	 */
	public String MessageFileWritten_Part1;
	/**
	 * Text from the MessageDialog file was written to... Part two
	 */
	public String MessageFileWritten_Part2;
	/**
	 * Text from the MessageDialog can not connect to server
	 */
	public String MessageCantConnectToServer;
	/**
	 * Text from the MessageDialog file already exists yes overwrite and no will append to file
	 */
	public String MessageFileExists;
	/**
	 * Text from the MessageDialog Title of the file already exists dialog
	 */
	public String MessageFileExistsTitle;
	/**
	 * Text from the MessageDialog want to generate hashes of the imported passwords (not jet been aktivated)
	 */
	public String MessageImportGenerateHash;
	/**
	 * Text from the MessageDialog Title of the generate hashes from import dialog
	 */
	public String MessageImportGenerateHashTitle;
	/**
	 * Text from the MessageDialog warning message because the user choosen a negative count of passwords to generate (program will negate the value
	 * to a positive number)
	 */
	public String MessageNegativeCount;
	/**
	 * Text from the MessageDialog Title of the negative count warning dialog
	 */
	public String MessageNegativeCountTitle;
	/**
	 * Text from the MessageDialog error because there are over all in the application too much passwords at the table (2.000.000) no additional
	 * passwords will be generated or added!
	 */
	public String MessageToMuchOverAllPasswords;
	/**
	 * Text from the MessageDialog Title of the over all too much passwords error dialog
	 */
	public String MessageToMuchOverAllPasswordsTitle;
	/**
	 * Text from the MessageDialog tell the user that a new version of this application is available on the Internet and he/she is with dialog asked
	 * if to want to download the newer version<br>
	 * <br>
	 * IMPORTANT!!!<br>
	 * use the variables "Main.version" for the current version<br>
	 * and the "Main.newVersion" for the new version that is to be download by user<br>
	 * <br>
	 * if you implement on or booth of this variables use it like that:<br>
	 * "YOUR TEXT" + Main.version + "YOUR TEXT" + Main.newVersion + "YOUR TEXT"<br>
	 */
	public String MessageUpdateNeedToUpdate;
	/**
	 * Text from the MessageDialog Title of the message to download the new version of the application
	 */
	public String MessageUpdateNeedToUpdateTitle;
	/**
	 * Text from the MessageDialog tell the user that the application is already up to date
	 */
	public String MessageUpdateUpToDate;
	/**
	 * Text from the MessageDialog Title of the message that the application is up to date
	 */
	public String MessageUpdateUpToDateTitle;
	/**
	 * Text from the MessageDialog tells that the user want to generate more than 2.000.000 passwords at one time
	 */
	public String MessageToMuchPasswords;
	/**
	 * Text from the MessageDialog Title of the message generate to much passwords a one time
	 */
	public String MessageToMuchPasswordsTitle;
	/**
	 * Text from the MessageDialog tells the user that he choose to generate zero passwords (will be set back to one)
	 */
	public String MessageZero;
	/**
	 * Text from the MessageDialog Title of the zero chosen message
	 */
	public String MessageZeroTitle;
	/**
	 * Text from the Label next to the up/down spinner (count of passwords to generate)
	 */
	public String PasswordCounter;
	/**
	 * Text from the RadioButton Gen.PW
	 */
	public String RadioButtonGeneratePassword;
	/**
	 * Text from the Table column "Password"
	 */
	public String TablePassword;
	/**
	 * Text from the context menu entry Copy at the table
	 */
	public String TablePopupMenuItemCopy;
	/**
	 * Text from the About Window - Author
	 */
	public String WindowAboutAuthor;
	/**
	 * Text from the About Window - Homepage
	 */
	public String WindowAboutHomepage;
	/**
	 * Text from the About Window - Window Title
	 */
	public String WindowAboutTitle;
	/**
	 * Text from the OK button at the About Window
	 */
	public String WindowAboutOKButton;
	/**
	 * Text from the Window News - Homepage
	 */
	public String WindowNewsHomepage;
	/**
	 * Text from the News Window - Window Title
	 */
	public String WindowNewsTitle;
	/**
	 * Text from the Pointless button at the News Window
	 */
	public String WindowNewsButtonPointless;
	/**
	 * Text from the Result text field at the Multi Hash Window
	 */
	public String WindowToolsMultiHashResult;

}
