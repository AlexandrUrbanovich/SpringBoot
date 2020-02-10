<#import "parts/common.ftl" as c>

<@c.page>

<a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
    Add new Word with description and translate
</a>
<div class="collapse" id="collapseExample">
    <div class="form-group mt-3">
        <form method="post" action="add" enctype="multipart/form-data">
            <div class="form-group">
                <input type="text" class="form-control" name="word" placeholder="Input word" />
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="description" placeholder="Input description">
            </div>
            <div class="form-group">
                 <input type="text" class="form-control" name="translate" placeholder="Input translate">
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Add</button>
            </div>
        </form>
    </div>
</div>

<br>
<br>
<br>
<br>

<div class="form-row">
    <div class="form-group col-md-6">
        <form method="get" action="/main" class="form-inline">
            <input type="text" name="filter" class="form-control" value="${filter}" placeholder="Search by word">
            <button type="submit" class="btn btn-primary ml-2">Search</button>
        </form>
    </div>
</div>

<div class="card-columns">
    <#list enWords as enWord>
    <div class="card my-3">
        <div class="m-2">
            <strong>${enWord.enWordId}</strong>
            <b>${enWord.word}</b>
            <i>${enWord.description}</i>
            <b>${enWord.ruWord.word}</b>
        </div>
    </div>
    <#else>
    No message
    </#list>
</div>

</@c.page>