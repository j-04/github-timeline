<#import "tl_head.ftl" as head>
<@head.head>
    <div id="timeline-content">
        <div class="alert alert-danger mx-auto w-50" role="alert">
            <h5>${code}: ${message}</h5>
        </div>
        <form action="/" method="get">
            <button type="submit" class="btn btn-secondary btn-sm w-25">Home page</button>
        </form>
    </div>
</@head.head>