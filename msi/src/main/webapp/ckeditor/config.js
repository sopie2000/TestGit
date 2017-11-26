/**
 * @license Copyright (c) 2003-2013, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.html or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';


	// KGC Edit  Start
		config.language = 'ko';

		config.toolbar = [
			{ name: 'document', groups: [ 'mode', 'document', 'doctools' ], items: [ 'Source' ] },
			{ name: 'clipboard', groups: [ 'clipboard', 'undo' ], items: [ 'Cut', 'Copy', 'Paste', 'PasteText', 'PasteFromWord', '-', 'Undo', 'Redo' ] },
			{ name: 'links', items: [ 'Link', 'Unlink', 'Anchor' ] },
			{ name: 'insert', items: [ 'Image', 'Table', 'HorizontalRule', 'SpecialChar' ] },
			{ name: 'justify', items: ['JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock'] },
			'/',
			{ name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ], items: [ 'Bold', 'Italic', 'Underline', 'Strike', 'Subscript', 'Superscript', 'RemoveFormat' ] },
			{ name: 'paragraph', groups: [ 'list', 'indent', 'blocks', 'align' ], items: [ 'NumberedList', 'BulletedList', '-', 'Outdent', 'Indent', '-', 'Blockquote' ] },
			{ name: 'font', items: [ 'Font'] },	
			{ name: 'styles', items: [  'FontSize' , 'Styles', 'Format' ] },
			{ name: 'colors', items: [ 'TextColor', 'BGColor' ] },
			{ name: 'tools', items: [ 'Maximize' ] },
			{ name: 'others', items: [ '-' ] },
			{ name: 'about', items: [ 'About' ] }
		];

		config.removeDialogTabs = 'image:advanced;link:advanced';
		config.format_tags = 'p;h1;h2;h3;pre';
		config.fontSize_defaultLabel = '12px';
		config.fontSize_sizes = '8/8px;9/9px;10/10px;11/11px;12/12px;14/14px;16/16px;18/18px;20/20px;22/22px;24/24px;26/26px;36/36px;48/48px;';
		config.font_defaultLabel = 'Gulim';
		config.font_names = 'Gulim/Gulim;Dotum/Dotum;Batang/Batang;Gungsuh/Gungsuh;Arial/Arial;Tahoma/Tahoma;Verdana/Verdana;';
		config.enterMode = CKEDITOR.ENTER_BR;
		config.shiftEnterMode = CKEDITOR.ENTER_P;
		config.startupFocus = true;
		config.dialog_buttonsOrder = 'rtl';
		config.extraAllowedContent = 'table[event_inner_table]';

        config.image_previewText = '이미지가 배치될 예시 내용입니다.<br />좌측 하단의 "정렬" 옵션을 선택하여, 이미지가 배치될 형태를 변경해보세요.';

/* 툴바 참고

['Source', '-', 'Save', 'Copy', 'Cut', 'Paste', 'PasteText', 'PasteFromWord', '-', 'Print', 'SpellChecker', 'Scayt' ],
['Undo', 'Redo', '-', 'Find', 'Replace', '-', 'SelectAll', 'RemoveFormat'],
['Form', 'Checkbox', 'Radio', 'TextField', 'Textarea', 'Select', 'Button', 'ImageButton', 'HiddenField'],
['Bold', 'Italic', 'Underline', 'Strike', '-', 'Subscript', 'Superscript'],
['NumberedList', 'BulletedList', '-', 'Outdent', 'Indent', 'Blockquote'],
['JustifyLeft', 'JustifyCenter', 'JustifyRight', 'JustifyBlock'],
['Link', 'Unlink', 'Anchor'],
['Image','Flash', 'Table', 'HorizontalRule', 'Smiley', 'SpecialChar', 'PageBrea'],
['Styles', 'Format', 'Font', 'FontSize', 'TextColor', 'BGColor'],
['Maximize', 'ShowBlocks', '-', 'About']
 */
	// KGC Edit End
};
