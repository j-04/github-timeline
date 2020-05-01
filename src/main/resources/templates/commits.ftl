<#import "tl_head.ftl" as head>

<@head.head>
    <ul class="timeline">
        <li class="event" data-date="Back to home page">
            <form action="/" method="get">
                <button type="submit" class="btn btn-dark btn-sm w-100">Home page</button>
            </form>
        </li>
        <li class="event" data-date="Back to repositories">
            <form action="/user/${login}/repos" method="get">
                <button type="submit" class="btn btn-dark btn-sm w-100">Repositories</button>
            </form>
        </li>
        <#list commits as commit>
            <#if commits?has_content>
                <li class="event" data-date="Commit">
                    <h3>SHA</h3>
                    <p>${commit.sha}</p>

                    <h3>Message</h3>
                    <p>${commit.commitProperty.message}</p>

                    <h3>Committer</h3>
                    <h5>Name</h5>
                    <p>${commit.commitProperty.committer.name}</p>
                    <h5>Email</h5>
                    <p>${commit.commitProperty.committer.email}</p>
                    <h5>Date</h5>
                    <p>${commit.commitProperty.committer.date}</p>

                    <form action="${commit.htmlUrl}" method="get">
                        <button type="submit" class="btn btn-dark btn-sm w-100">Commit on github</button>
                    </form>
                </li>
            <#else>
                <li class="event" data-date="Commits not found">
                    <h2>Commits not found</h2>
                </li>
            </#if>
        </#list>
    </ul>
</@head.head>