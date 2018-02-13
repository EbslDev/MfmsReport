<html>
<head>Towngas e-Patrol System</head>
<body>
<h1>Towngas e-Patrol System WebServices</h1>
<h2>Patrol Routine</h2>
<p>
<a href="http://localhost:8080/MfmsReport/rest/generatePatrolReportWs/test">test generatePatrolReportWs</a>
</p>
<p>
<a href="http://localhost:8080/MfmsReport/rest/generatePatrolReportWs/requestPatrolRoutineJson?siteKey=2">requestPatrolRoutineJson</a><br/>
sample query string:<br/>
http://localhost:8080/MfmsReport/rest/generatePatrolReportWs/requestPatrolRoutineJson?siteKey=2&amp;routeKeyList=1,2,3,4&amp;resultStartDate=19700101_000000&amp;resultEndDate=20180101_235900<br/>
</p>
<p>
<a href="http://localhost:8080/MfmsReport/rest/generatePatrolReportWs/requestPatrolRoutineExcel?siteKey=2">requestPatrolRoutineExcel</a><br/>
http://localhost:8080/MfmsReport/rest/generatePatrolReportWs/requestPatrolRoutineExcel?siteKey=2&amp;routeKeyList=1,2,3,4&amp;resultStartDate=19700101_000000&amp;resultEndDate=20180101_235900<br/>
</p>
<h2>Inspection Report</h2>
<p>
<a href="http://localhost:8080/MfmsReport/rest/generateInspectionReportWs/test">test generateInspectionReportWs</a><br/>
</p>
<p>
<a href="http://localhost:8080/MfmsReport/rest/generateInspectionReportWs/requestInspectionJson?siteKey=2&routeKeyList=1,2,3,4&resultStartDate=19700101_000000&resultEndDate=20180101_235900">requestInspectionJson</a><br/>
</p>
<p>
<a href="http://localhost:8080/MfmsReport/rest/generateInspectionReportWs/requestInspectionExcel?siteKey=2&routeKeyList=1,2,3,4&resultStartDate=19700101_000000&resultEndDate=20180101_235900">requestInspectionExcel</a><br/>
</p>
</body>
</html>