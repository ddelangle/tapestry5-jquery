//
// Copyright 2010 GOT5 (Gang Of Tapestry 5)
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// 	http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//

package org.got5.tapestry5.jquery.mixins;
import org.apache.tapestry5.Asset;
import org.apache.tapestry5.annotations.Path;
import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

import org.apache.tapestry5.annotations.Import;
import org.got5.tapestry5.jquery.services.FormResourcesInclusionWorker;
import org.got5.tapestry5.jquery.services.javascript.FormSupportStack;


/**
 * This mixin is automatically added by {@link FormResourcesInclusionWorker}. It
 * adds JS & CSS for form elements
 */
@Import(stack = FormSupportStack.STACK_ID)
public class IncludeFormResources
{
    @Inject
    private JavaScriptSupport support;

    @Inject
    @Path("classpath:org/got5/tapestry5/jquery/jquery.validate.min.js")
    private Asset validationScript;

    @Inject
    @Path("classpath:org/got5/tapestry5/jquery/validation.js")
    private Asset scriptInitializer;

    @Inject
    @Path("classpath:org/got5/tapestry5/jquery/form.css")
    private Asset formCSS;

    @SetupRender
    public void addJSValidationScripts()
    {
        support.importJavaScriptLibrary(validationScript);
        support.importJavaScriptLibrary(scriptInitializer);
        support.importStylesheet(formCSS);
    }

}
