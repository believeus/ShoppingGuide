//身份证号码的验证
jQuery.validator.addMethod("idnumber", function(value, element) {
	return this.optional(element) || (/^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$/.test(value)&&/^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/.test(value));
}, " 请正确输入您的身份证号码 ");

