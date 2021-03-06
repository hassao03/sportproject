# Sport App Dev Tech Challenge
BBC Sport App Developer Technical Assessment

<img src="https://github.com/bbc/sport-app-dev-tech-challenge/blob/master/resources/IMG_4209.PNG" alt="MySport Formula 1" width="30%">

## The Challenge

This challenge is all about your mobile application developer skills. The rough idea is that you:

* make a call to a url to retrieve some data
* represent that data in an application
* display that data in a user friendly.
* write stats about app usage to a url

The data is the same format as we use for the MySport feature in the app. So that means you're really creating part of a mini sport app! We're going to focus on displaying some Formaula 1 headlines data via an API. This is a small slice of the same tech we use to power all of the data to our 25 million strong audience! Pretty cool :)

When it comes to tech here we like Swift (https://developer.apple.com/swift/) for iOS and Kotlin (https://kotlinlang.org/docs/reference/android-overview.html) for Android, but you're free to use any language you feel comfortable with. You can also:

* use **any** frameworks you want to help you create it
* **Google anything you want** to find out

This repo contains a base for iPhone and one for Android to help you get started (they're pretty basic but they'll give you some direction). At this point we're guessing you're pretty nervous. Don't worry, we're not expecting you to do this on your own! Throughout the challenge you'll have one of our brilliant developers to work with. This isn't someone who will secretly be assessing you or just sitting there like a lemon saying "well, what do you think?", they're there to pair with you and build this thing with you together.

You'll have **one and half hours** to get as far as you can on building the components. We're **not expecting you to finish** this btw - it's a large challenge and realistically would take a lot longer to finish properly (it'd be much better to do a small part really well than trying to get every part done badly).

## Why are we putting you through this?

We'd like to see how you go about tackling a problem whilst working with others. We've tried to make this as natural and as non-constrictive a challenge as possible. Our hope is that you feel relaxed (yeah that's not going to happen but we're trying :S) and you have all the tools you'll need to show yourself off in the best light. We'll be looking at things like dev skills (coding, tech knowledge, analytical thinking etc), team-working and communication skills as well as how you approach problems.

## The Rules
* You'll have one and half hours
* You'll be working with someone as pair
* You can Google anything you want
* Raise a PR when your time is up (please don't commit to master, being on a branch is fine)

## Spec
* Read some sport story data (json)
* Parse the data
* Display the data in the app in a way similar to the image above
* Allow a forward journey to the appropriate article
* Record statistics about the app use:
  * The command is ???event??? and the parameters are ???load???, ???display??? and ???error???.
  * ???load??? and ???display??? should be followed by a ???data??? parameter containing the time in milliseconds.
  * ???error??? should be followed by a ???data??? parameter containing an error reason string.


## Data
We've provided a json feed at https://bbc.github.io/sport-app-dev-tech-challenge/data.json

We've provided an endpoint for the stats at https://bbc.github.io/sport-app-dev-tech-challenge/stats

  Example stats:

    https://bbc.github.io/sport-app-dev-tech-challenge/stats?event=display&data=1235
    https://bbc.github.io/sport-app-dev-tech-challenge/stats?event=error&data=its%20all%20gone%20to%20pot

## Checkout
* Checkout: `git clone git@github.com:bbc/sport-app-dev-tech-challenge.git`

## I'm pairing on this exercise, what do I need?
Thanks for volunteering! To pair with a candidate all you need is either Xcode or Android Studio, depending on their preference.
