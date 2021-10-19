# Lab: 16 - Spring Auth
build an app that allows users to create their profile on CodeFellowship.

* The site should have a splash page at the root route (/) that contains basic information about the site, as well as a link to the “sign up” page.
* An ApplicationUser should have a username, password (will be hashed using BCrypt), firstName, lastName, dateOfBirth, bio, and any other fields you think are useful.
* The site should allow users to create an ApplicationUser on the “sign up” page.
  Your Controller should have an @Autowired private PasswordEncoder passwordEncoder; and use that to run passwordEncoder.encode(password) before saving the password into the new user.

********************************************************** LAB17 ****************************************************
Lab: 17 - Spring Authorization

Allow users to log in to CodeFellowship and create posts.

Using the above cheat sheet, add the ability for users to log in to your app.
Upon logging in, users should be taken to a /myprofile route that displays their information.
Ensure that your homepage, login, and registration routes are accessible to non-logged in users. All other routes should be limited to logged-in users.
Ensure that user registration also logs users into your app automatically.
Add a Post entity to your app.
A Post has a body and a createdAt timestamp.
A logged-in user should be able to create a Post, and a post should belong to the user that created it.
hint: this is a relationship between two pieces of data