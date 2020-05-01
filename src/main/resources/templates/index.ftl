<#import "tl_head.ftl" as head>

<@head.head>
    <div id="timeline-content">
        <form action="/user" method="get">
            <div class="input-group mx-auto w-50">
                <div class="input-group-prepend">
                    <span class="input-group-text" id="inputGroup-sizing-default">Your GitHub login</span>
                </div>
                <input type="text" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-default" name="login">
                <button type="submit" class="btn btn-dark">Generate</button>
            </div>
        </form>
    </div>
</@head.head>