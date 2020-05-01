<#import "tl_head.ftl" as head>

<@head.head>
    <ul class="timeline" xmlns="http://www.w3.org/1999/html">
        <li class="event" data-date="Back to home page">
            <form action="/" method="get">
                <button type="submit" class="btn btn-dark btn-sm w-100">Home page</button>
            </form>
        </li>
        <li class="event" data-date="Back to your account">
            <form action="/user" method="get">
                <input type="hidden" name="login" value="${login}">
                <button type="submit" class="btn btn-dark btn-sm w-100">You</button>
            </form>
        </li>
        <li class="event" data-date="Quantity of repos">
            <h4>${rsize}</h4>
        </li>
        <#list repos as repo>
            <#if repos?size != 0>
            <li class="event" data-date="${repo.createdAt}">
                <h4>Id</h4>
                <p>${repo.id}</p>

                <h4>Name</h4>
                <p>${repo.name}</p>

                <h4>Description</h4>
                <p>${repo.description}</p>

                <h4>Stars</h4>
                <p>${repo.stars}</p>

                <h4>Watchers</h4>
                <p>${repo.watchers}</p>

                <h4>Updated at</h4>
                <p>${repo.updatedAt}</p>

                <form action="/user/${login}/repo/${repo.name}/commits" method="get">
                    <button type="submit" class="btn btn-dark btn-sm w-100">Commits</button>
                </form>
                </br>
                <form action="${repo.htmlUrl}" method="get">
                    <button type="submit" class="btn btn-dark btn-sm w-100">Repo on github</button>
                </form>
            </li>
            <#else>
                <li class="event" data-date="Repositories not found">
                    <h2>Repositories not found</h2>
                </li>
            </#if>
        </#list>
    </ul>
</@head.head>