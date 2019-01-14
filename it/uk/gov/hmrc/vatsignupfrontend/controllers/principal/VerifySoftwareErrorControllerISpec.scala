/*
 * Copyright 2018 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.vatsignupfrontend.controllers.principal

import play.api.http.Status._
import uk.gov.hmrc.vatsignupfrontend.helpers.{ComponentSpecBase, CustomMatchers}

class VerifySoftwareErrorControllerISpec extends ComponentSpecBase with CustomMatchers {
  "GET /error/verify-software" should {
    "return an OK" in {

      val res = get("/error/verify-software")

      res should have(
        httpStatus(OK)
      )
    }
  }

  "POST /error/verify-software" should {
    "redirect to the gov.uk guidance page" in {

      val res = post("/error/verify-software")()

      res should have(
        httpStatus(SEE_OTHER),
        redirectUri(appConfig.guidancePageUrl)
      )
    }
  }
}