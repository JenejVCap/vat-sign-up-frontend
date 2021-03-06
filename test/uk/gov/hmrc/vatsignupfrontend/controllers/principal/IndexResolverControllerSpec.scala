/*
 * Copyright 2019 HM Revenue & Customs
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

import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import play.api.http.Status
import play.api.test.FakeRequest
import play.api.test.Helpers._
import uk.gov.hmrc.play.test.UnitSpec
import uk.gov.hmrc.vatsignupfrontend.config.mocks.MockControllerComponents

class IndexResolverControllerSpec extends UnitSpec with GuiceOneAppPerSuite with MockControllerComponents {

  object TestIndexResolverController extends IndexResolverController(mockControllerComponents)

  lazy val testGetRequest = FakeRequest("GET", "/index")

  "Calling the resolve action of the Index Resolver controller" should {
    "show the Have Software page" in {
      val request = testGetRequest

      val result = TestIndexResolverController.resolve(request)
      status(result) shouldBe Status.SEE_OTHER
      redirectLocation(result) shouldBe Some(routes.HaveSoftwareController.show().url)
    }
  }

}
