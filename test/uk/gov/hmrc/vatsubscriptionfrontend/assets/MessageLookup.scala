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

package assets


object MessageLookup {

  object Base {
    val continue = "Continue"
    val continueToSignUp = "Continue to sign up"
    val confirmAndContinue = "Confirm and continue"
    val agreeAndContinue = "Agree and continue"
    val submit = "Submit"
    val update = "Update"
    val signOut = "Sign out"
    val signUp = "Sign up"
    val goBack = "Go back"
  }

  object ErrorMessage {
    val invalidVatNumber = "Please enter a valid vat registration number"
    val invalidCompanyNumber  = "Please enter a valid company registration number"
  }

  object CaptureVatNumber {
    val title = "What is your client's VAT number?"
    val heading: String = title
    val description = "This is the 9-digit number they received when they registered for VAT."
    val hint = "For example, 123456789"
  }

  object ConfirmVatNumber {
    val title = "Confirm your client's VAT number"
    val heading: String = title
    val vatNumberHeading = "VAT number"
    val link = "Change VAT number"
  }

  object CaptureCompanyNumber {
    val title = "What is your client's company registration number?"
    val heading: String = title
  }

  object CaptureBusinessEntity {
    val title = "What type of business is your client registered as?"
    val heading: String = title
    val radioSoleTrader: String = "Sole trader"
    val radioLimitedCompany: String = "Limited company"
  }

  object ConfirmCompanyNumber {
    val title = "Confirm your client's company registration number"
    val heading: String = title
    val companyNumberHeading = "Company registration number"
    val link = "Change company registration number"
  }

  object AgreeCaptureEmail {
    val title = "Agree to get emails instead of letters"
    val heading: String = title
    val line1 = "When your client has a new message about VAT in their HMRC account, we'll send an email to let them know."
    val line2 = "They'll need to sign in to their account account to read the message."
  }

  object CaptureEmail {
    val title = "What is your client’s email address?"
    val heading: String = title
    val hint = "For example, me@me.com"
  }


}