/**
 * Created by evan_qb on 2018/1/25.
 */
// 选择日期和时间
// 限制可选日期
$('#date_e').cxCalendar({
    /*wday: 0,
     onday: [1,2,3,4,5],
     // type: 'datetime',
     // format: 'YYYY-MM-DD HH:mm:ss',
     unday: [
     '3',
     '7-5',
     '7-15',
     '7-25',
     '2017-7-10',
     '2017-7-20',
     '2017-7-30'
     ],
     endDate: '2017-08-31'*/
});

// 选择日期和时间
$('#date_d').cxCalendar({
    type: 'datetime',
    format: 'YYYY-MM-DD HH:mm:ss'
});

/*入学时间*/
$("#date_start").cxCalendar();
/*毕业时间*/
$('#date_gradual').cxCalendar();
$("#rdesiredWorktime").cxCalendar();