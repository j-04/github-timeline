<#ftl encoding='UTF-8'>
<#import "tl_head.ftl" as head>
<@head.head>
    <ul class="timeline" ${user}>
        <li class="event" data-date="Back to home page">
            <form action="/" method="get">
                <button type="submit" class="btn btn-dark btn-sm w-100">Home page</button>
            </form>
        </li>
        <li class="event" data-date="Avatar">
            <p><img class ="responsive" src="${user.avatarUrl}"></p>
        </li>
        <li class="event" data-date="Id">
            <p>${user.id}</p>
        </li>
        <li class="event" data-date="Login">
            <p>${user.login}</p>
        </li>
        <li class="event" data-date="Name">
            <p>${user.name}</p>
        </li>
        <li class="event" data-date="Bio">
            <p>${user.bio}</p>
        </li>
        <li class="event" data-date="Email">
            <p>${user.email}</p>
        </li>
        <li class="event" data-date="Created at">
            <p>${user.createdAt}</p>
        </li>
        <li class="event" data-date="Company">
            <p>${user.company}</p>
        </li>
        <li class="event" data-date="Type">
            <p>${user.type}</p>
        </li>
        <li class="event" data-date="Followers">
            <p>${user.followers}</p>
        </li>
        <li class="event" data-date="Following">
            <p>${user.following}</p>
        </li>
        <li class="event" data-date="Repositories">
            <form action="/user/${user.login}/repos" method="get">
                <button type="submit" class="btn btn-dark btn-sm w-100">Repositories</button>
            </form>
        </li>
        <li class="event" data-date="Back to home page">
            <form action="/" method="get">
                <button type="submit" class="btn btn-dark btn-sm w-100">Home page</button>
            </form>
        </li>
    </ul>
</@head.head>