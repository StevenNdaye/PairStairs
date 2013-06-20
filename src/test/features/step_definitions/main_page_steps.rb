Given /^I visit the main page$/ do
  @driver.navigate.to "http://localhost:8080/PairStairs/static/index.html"
end

Then /^I should be greeted with "([^"]*)"$/ do |expected_greeting|
  greeting = @driver.find_element(:tag_name, "h1")
  greeting.text.should eq(expected_greeting)
end

When /^I enter a developer name as "([^"]*)"$/ do |expected_developer|
   new_developer = @driver.find_element(:id, "createDeveloperNameTextBox")
   new_developer.send_keys(expected_developer)
end

And /^I click on the "Create" button$/ do
    create_button =  @driver.find_element(:id, "createDeveloperNameButton")
    create_button.click
end

Then /^I should see id "([^"]*)", name "([^"]*)"$/ do |expected_id, expected_developer|
    wait = Selenium::WebDriver::Wait.new(:timeout => 10) # seconds
    wait.until {@driver.find_element(:id, "developer_#{expected_id}") }

    table_row = @driver.find_element(:id, "developer_#{expected_id}")

    id = table_row.find_element(:class_name, "id")
    name = table_row.find_element(:class_name, "name")
    id.text.should eq(expected_id)
    name.text.should eq(expected_developer)
end

When /^I enter developer ID "([^"]*)" in the Developer ID textbox$/ do |expected_id|
   current_id = @driver.find_element(:id, "deleteDeveloperIdTextBox")
   current_id.send_keys(expected_id)
end

And /^I click on the "Delete" button$/ do
    delete_button =  @driver.find_element(:id, "deleteDeveloperIdButton")
    delete_button.click
end

Then /^Developer with ID "([^"]*)" should be deleted from the list of developers$/ do |expected_id|
   wait = Selenium::WebDriver::Wait.new(:timeout => 10) # seconds
   wait.until {
        begin
            current_id = @driver.find_element(:id, "developer_#{expected_id}")
            false
        rescue Selenium::WebDriver::Error::NoSuchElementError
            true
        end
   }
end
