<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>

<div>
    <@l.logout />
    <span><a href="/user">User list</a></span>
</div>

<div>
    <form method="post" action="add">
        <input type="text" name="word" placeholder="Input word" />
        <input type="text" name="description" placeholder="Input description">
        <input type="text" name="translate" placeholder="Input translate">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit">Add</button>
    </form>
</div>

<div>Word list</div>
<form method="get" action="/main">
    <input type="text" name="filter" value="${filter}">
    <button type="submit">Search</button>
</form>

<#list enWords as enWord>
<div>
    <strong>${enWord.enWordId}</strong>
    <b>${enWord.word}</b>
    <i>${enWord.description}</i>
    <b>${enWord.ruWord.word}</b>
</div>
<#else>
No message
</#list>

</@c.page>