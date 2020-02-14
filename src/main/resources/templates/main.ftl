<#import "parts/common.ftl" as c>

<@c.page>

<a class="btn btn-primary" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
    Add new Word with description and translate
</a>
<div class="form-row">
    <div class="form-group mt-3">
        <form method="post" action="add" enctype="multipart/form-data">
            <div class="form-group">
                <input type="text" class="form-control ${(wordError??)?string('is-invalid', '')}"
                value="<#if enWord??>${enWord.word}</#if>" name="word" placeholder="Input word" />
                <#if wordError??>
                    <div class="invalid-feedback">
                        ${wordError}
                    </div>
                </#if>
            </div>
            <div class="form-group">
                <input type="text" class="form-control ${(descriptionError??)?string('is-invalid', '')}"
                value="<#if enWord??>${enWord.description}</#if>" name="description" placeholder="Input description">
                <#if descriptionError??>
                    <div class="invalid-feedback">
                        ${descriptionError}
                    </div>
                </#if>
            </div>
            <div class="form-group">
                 <input type="text" class="form-control ${(translateError??)?string('is-invalid', '')}"
                 value="<#if enWord??>${enWord.ruWord.translate}</#if>" name="translate" placeholder="Input translate">
                 <#if translateError??>
                    <div class="invalid-feedback">
                        ${translateError}
                    </div>
                 </#if>
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
            <input type="text" name="filter" class="form-control" value="${filter?ifExists}" placeholder="Search by word">
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
            <b>${enWord.ruWord.translate}</b>
        </div>
    </div>
    <#else>
    No message
    </#list>
</div>

</@c.page>