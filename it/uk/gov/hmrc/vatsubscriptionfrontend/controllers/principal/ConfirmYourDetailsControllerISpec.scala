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

package uk.gov.hmrc.vatsubscriptionfrontend.controllers.principal

import java.time.LocalDate
import java.util.UUID

import play.api.http.Status._
import play.api.libs.json.Json
import uk.gov.hmrc.vatsubscriptionfrontend.SessionKeys
import uk.gov.hmrc.vatsubscriptionfrontend.helpers.IntegrationTestConstants._
import uk.gov.hmrc.vatsubscriptionfrontend.helpers.servicemocks.AuthStub._
import uk.gov.hmrc.vatsubscriptionfrontend.helpers.servicemocks.StoreNinoStub._
import uk.gov.hmrc.vatsubscriptionfrontend.helpers.{ComponentSpecBase, CustomMatchers}
import uk.gov.hmrc.vatsubscriptionfrontend.models.{DateModel, UserDetailsModel}

class ConfirmYourDetailsControllerISpec extends ComponentSpecBase with CustomMatchers {

  val testUserDetails: UserDetailsModel = UserDetailsModel(
    firstName = UUID.randomUUID().toString,
    lastName = UUID.randomUUID().toString,
    nino = testNino,
    dateOfBirth = DateModel.dateConvert(LocalDate.now())
  )

  val testUserDetailsJson: String = Json.toJson(testUserDetails).toString()

  "GET /confirm-details" should {
    "return an OK" in {
      stubAuth(OK, successfulAuthResponse())

      val res = get("/confirm-details", Map(SessionKeys.userDetailsKey -> testUserDetailsJson))

      res should have(
        httpStatus(OK)
      )
    }
  }

  "POST /confirm-details" when {
    "store nino is successful" should {
      "redirect to capture email page" in {
        stubAuth(OK, successfulAuthResponse())
        stubStoreNinoSuccess(testVatNumber, testUserDetails)

        val res = post("/confirm-details", Map(SessionKeys.userDetailsKey -> testUserDetailsJson))()

        res should have(
          httpStatus(SEE_OTHER),
          redirectUri(routes.CaptureEmailController.show().url)
        )
      }
    }

    "store nino returned no match" should {
      "INTERNAL_SERVER_ERROR" in {
        stubAuth(OK, successfulAuthResponse())
        stubStoreNinoNoMatch(testVatNumber, testUserDetails)

        val res = post("/confirm-details", Map(SessionKeys.userDetailsKey -> testUserDetailsJson))()

        res should have(
          httpStatus(INTERNAL_SERVER_ERROR)
        )
      }
    }
  }

}
