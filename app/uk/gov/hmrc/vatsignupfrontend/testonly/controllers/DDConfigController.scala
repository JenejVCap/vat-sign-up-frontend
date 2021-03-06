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

package uk.gov.hmrc.vatsignupfrontend.testonly.controllers

import javax.inject.{Inject, Singleton}

import play.api.libs.json.Json
import play.api.mvc.{Action, AnyContent}
import uk.gov.hmrc.play.bootstrap.controller.BaseController
import uk.gov.hmrc.vatsignupfrontend.testonly.connectors.DDConfigConnector
import uk.gov.hmrc.vatsignupfrontend.testonly.httpparsers.DDConfigHttpParser.DDConfigFailure

import scala.concurrent.ExecutionContext


@Singleton
class DDConfigController @Inject()(ddConfigConnector: DDConfigConnector,
                                   implicit val executionContext: ExecutionContext) extends BaseController {

  def show: Action[AnyContent] = Action.async { implicit request =>
    ddConfigConnector.getConfig.map {
      case Right(response) => Ok(response)
      case Left(reason: DDConfigFailure) => BadGateway(Json.toJson(reason))
    }
  }

}
