FCKConfig.AutoDetectLanguage = false ;
FCKConfig.DefaultLanguage = "zh-cn" ;
FCKConfig.StartupFocus = false ;

FCKConfig.LinkUpload = true ;
FCKConfig.LinkBrowser = true ;

FCKConfig.ImageBrowser = true ;

FCKConfig.Plugins.Add('simplecommands');

FCKConfig.ToolbarSets["mydefault"] = [
	['Source','FitWindow','Preview','Save'],
	['Templates','Print'],
	['Cut','Copy','Paste','PasteText','PasteWord'],
	['Undo','Redo','-','Find','Replace','-','SelectAll','RemoveFormat'],
	['Form','Checkbox','Radio','TextField','Textarea','Select','Button','ImageButton','HiddenField'],
	['Bold','Italic','Underline','StrikeThrough','-','Subscript','Superscript'],
	['OrderedList','UnorderedList','-','Outdent','Indent','Blockquote','CreateDiv'],
	['JustifyLeft','JustifyCenter','JustifyRight','JustifyFull'],
	['Link','Unlink','Anchor'],
	['Image','Flash','Table','Rule','SpecialChar'],
	['StyleSimple','FontFormatSimple','FontNameSimple','FontSizeSimple'],
	['TextColor','BGColor'],
	['PageBreak']
];

FCKConfig.ToolbarSets["noFormAttr"] = [
   ['FitWindow','Preview','Templates'],
   ['Cut','Copy','Paste','PasteText','PasteWord'],
   ['Bold','Italic','Underline','StrikeThrough','-','Subscript','Superscript'],
   ['OrderedList','UnorderedList','-','Outdent','Indent','Blockquote'],
   ['Link','Unlink','Anchor'],
   ['Image','Flash','Table','Rule','SpecialChar'],
   ['StyleSimple','FontFormatSimple','FontNameSimple','FontSizeSimple','TextColor','BGColor'],
   ['PageBreak']
];

FCKConfig.ToolbarSets["simpleBar"] = [
   ['FitWindow','Templates','Print','Cut','Copy','Paste','PasteText','PasteWord'],
   ['Undo','Redo','-','Find','Replace','-','SelectAll','RemoveFormat'],
   ['Bold','Italic','Underline','StrikeThrough','-','Subscript','Superscript'],
   ['OrderedList','UnorderedList','-','Outdent','Indent','Blockquote'],
   ['JustifyLeft','JustifyCenter','JustifyRight','JustifyFull'],
   ['Link','Unlink','Anchor'],
   ['Image','Flash','Table','Rule','SpecialChar'],
   ['StyleSimple','FontFormatSimple','FontNameSimple','FontSizeSimple'],
   ['TextColor','BGColor']
];

FCKConfig.ToolbarSets["Readonly"] = [ 
     ['FitWindow','Preview','Print'] 
] ; 
