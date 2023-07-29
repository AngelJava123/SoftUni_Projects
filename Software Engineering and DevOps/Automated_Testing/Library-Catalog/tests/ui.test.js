const { test, expect } = require('@playwright/test');

// Navigation Bar for Guest Users

test('Verify "All Books" link is visible', async ({ page }) => {
    await page.goto('http://localhost:3000');
    await page.waitForSelector('nav.navbar');

    const allBooksLink = await page.$('a[href="/catalog"]');

    const isLinkVisible = await allBooksLink.isVisible();

    expect(isLinkVisible).toBe(true);
});

test('Verify "Login" button is visible', async ({ page }) => {
    await page.goto('http://localhost:3000');
    await page.waitForSelector('nav.navbar');

    const loginButton = await page.$('a[href="/login"]');

    const isLoginButtonVisible = await loginButton.isVisible();

    expect(isLoginButtonVisible).toBe(true);
});

test('Verify "Register" button is visible', async ({ page }) => {
    await page.goto('http://localhost:3000');
    await page.waitForSelector('nav.navbar');

    const registerButton = await page.$('a[href="/register"]');

    const isRegisterButtonVisible = await registerButton.isVisible();

    expect(isRegisterButtonVisible).toBe(true);
});

// Navigation Bar for Logged-In Users

test('Verify "All Books" link is visible after user login', async ({ page }) => {
    await page.goto('http://localhost:3000/login');
    
    await page.fill('input[name="email"]', 'peter@abv.bg');
    await page.fill('input[name="password"]', '123456');
    await page.click('input[type="submit"]');

    const allBooksLink = await page.$('a[href="/catalog"]');
    const isAllBooksLinkVisible = await allBooksLink.isVisible();

    expect(isAllBooksLinkVisible).toBe(true);
});

test('Verify "My Books" button is visible after user login', async ({ page }) => {
    await page.goto('http://localhost:3000/login');
    
    await page.fill('input[name="email"]', 'peter@abv.bg');
    await page.fill('input[name="password"]', '123456');
    await page.click('input[type="submit"]');

    const myBooksLink = await page.$('a[href="/profile"]');
    const myBooksLinkVisible = await myBooksLink.isVisible();

    expect(myBooksLinkVisible).toBe(true);
});

test('Verify "Add Book" button is visible after user login', async ({ page }) => {
    await page.goto('http://localhost:3000/login');
    
    await page.fill('input[name="email"]', 'peter@abv.bg');
    await page.fill('input[name="password"]', '123456');
    await page.click('input[type="submit"]');

    const addBookLink = await page.$('a[href="/create"]');
    const addBookLinkVisible = await addBookLink.isVisible();

    expect(addBookLinkVisible).toBe(true);
});

test('Verify That the User`s Email Address Is Visible', async ({ page }) => {
    await page.goto('http://localhost:3000/login');
    
    await page.fill('input[name="email"]', 'peter@abv.bg');
    await page.fill('input[name="password"]', '123456');
    await page.click('input[type="submit"]');

    const welcomeSpan = await page.$('span'); // Assuming there's only one span element with the text "Welcome, peter@abv.bg"
    const welcomeSpanVisible = await welcomeSpan.isVisible();

    expect(welcomeSpanVisible).toBe(true);
});

// Login Page

test('Login with valid credentials', async ({ page }) => {
    await page.goto('http://localhost:3000/login');
    
    await page.fill('input[name="email"]', 'peter@abv.bg');
    await page.fill('input[name="password"]', '123456');
    await page.click('input[type="submit"]');

    await page.$('a[href="/catalog"]');
    expect(page.url()).toBe('http://localhost:3000/catalog');
});

test('Login with empty input fields', async ({ page }) => {
    await page.goto('http://localhost:3000/login');
    await page.click('input[type="submit"]');

    page.on('dialog', async dialog => {
        expect(dialog.type()).toContain('alert');
        expect(dialog.message()).toContain('All fields are required!');
        await dialog.accept();
    });

    await page.$('a[href="/login"]');
    expect(page.url()).toBe('http://localhost:3000/login');
});

test('Submit the Form with Empty Email Input Field', async ({ page }) => {
    await page.goto('http://localhost:3000/login');
    await page.fill('input[name="password"]', '123456');
    await page.click('input[type="submit"]');

    page.on('dialog', async dialog => {
        expect(dialog.type()).toContain('alert');
        expect(dialog.message()).toContain('All fields are required!');
        await dialog.accept();
    });

    await page.$('a[href="/login"]');
    expect(page.url()).toBe('http://localhost:3000/login');
});

test('Submit the Form with Empty Password Input Field', async ({ page }) => {
    await page.goto('http://localhost:3000/login');
    await page.fill('input[name="email"]', 'peter@abv.bg');
    await page.click('input[type="submit"]');

    page.on('dialog', async dialog => {
        expect(dialog.type()).toContain('alert');
        expect(dialog.message()).toContain('All fields are required!');
        await dialog.accept();
    });

    await page.$('a[href="/login"]');
    expect(page.url()).toBe('http://localhost:3000/login');
});

// Register Page

test('Submit the Form with Valid Values', async ({ page }) => {
    await page.goto('http://localhost:3000/register');
    await page.fill('input[name="email"]', 'test@abv.bg');
    await page.fill('input[name="password"]', '123456');
    await page.fill('input[name="confirm-pass"]', '123456');
    await page.click('input[type="submit"]');

    await page.$('a[href="/catalog"]');
    expect(page.url()).toBe('http://localhost:3000/catalog');
});

test('Submit the Form with Empty Values', async ({ page }) => {
    await page.goto('http://localhost:3000/register');
    await page.click('input[type="submit"]');

    page.on('dialog', async dialog => {
        expect(dialog.type()).toContain('alert');
        expect(dialog.message()).toContain('All fields are required!');
        await dialog.accept();
    });

    await page.$('a[href="/register"]');
    expect(page.url()).toBe('http://localhost:3000/register');
});

test('Submit the Form with Empty Email', async ({ page }) => {
    await page.goto('http://localhost:3000/register');
    await page.fill('input[name="password"]', '123456');
    await page.fill('input[name="confirm-pass"]', '123456');
    await page.click('input[type="submit"]');

    page.on('dialog', async dialog => {
        expect(dialog.type()).toContain('alert');
        expect(dialog.message()).toContain('All fields are required!');
        await dialog.accept();
    });

    await page.$('a[href="/register"]');
    expect(page.url()).toBe('http://localhost:3000/register');
});

test('Submit the Form with Empty Password', async ({ page }) => {
    await page.goto('http://localhost:3000/register');
    await page.fill('input[name="email"]', 'test@abv.bg');
    await page.fill('input[name="confirm-pass"]', '123456');
    await page.click('input[type="submit"]');

    page.on('dialog', async dialog => {
        expect(dialog.type()).toContain('alert');
        expect(dialog.message()).toContain('All fields are required!');
        await dialog.accept();
    });

    await page.$('a[href="/register"]');
    expect(page.url()).toBe('http://localhost:3000/register');
});

test('Submit the Form with Empty Confirm Password', async ({ page }) => {
    await page.goto('http://localhost:3000/register');
    await page.fill('input[name="email"]', 'test@abv.bg');
    await page.fill('input[name="password"]', '123456');
    await page.click('input[type="submit"]');

    page.on('dialog', async dialog => {
        expect(dialog.type()).toContain('alert');
        expect(dialog.message()).toContain('All fields are required!');
        await dialog.accept();
    });

    await page.$('a[href="/register"]');
    expect(page.url()).toBe('http://localhost:3000/register');
});

test('Submit the Form with Different Passwords', async ({ page }) => {
    await page.goto('http://localhost:3000/register');
    await page.fill('input[name="email"]', 'test@abv.bg');
    await page.fill('input[name="password"]', '123456');
    await page.fill('input[name="confirm-pass"]', '676767');
    await page.click('input[type="submit"]');

    page.on('dialog', async dialog => {
        expect(dialog.type()).toContain('alert');
        expect(dialog.message()).toContain('Passwords don\'t match!');
        await dialog.accept();
    });

    await page.$('a[href="/register"]');
    expect(page.url()).toBe('http://localhost:3000/register');
});

// "Add Book" Page

test('Submit the Form with Correct Data', async ({ page }) => {
    await page.goto('http://localhost:3000/login');
  
    await page.fill('input[name="email"]', 'peter@abv.bg');
    await page.fill('input[name="password"]', '123456');
  
    await Promise.all([
      page.click('input[type="submit"]'),
      page.waitForURL('http://localhost:3000/catalog')
    ]);
  
    await page.click('a[href="/create"]');
  
    await page.waitForSelector('#create-form');
  
    await page.fill('#title', 'Test Book');
    await page.fill('#description', 'This is a test book description');
    await page.fill('#image', 'https://example.com/book-image.jpg');
    await page.selectOption('#type', 'Fiction');
  
    await Promise.all([
      page.waitForNavigation(), // Wait for the navigation to complete after clicking submit
      page.click('#create-form input[type="submit"]')
    ]);
  
    await page.waitForURL('http://localhost:3000/catalog');
    expect(page.url()).toBe('http://localhost:3000/catalog');
  });

  test('Submit the Form with Empty Title Field', async ({ page }) => {
    await page.goto('http://localhost:3000/login');
  
    await page.fill('input[name="email"]', 'peter@abv.bg');
    await page.fill('input[name="password"]', '123456');
  
    await Promise.all([
      page.click('input[type="submit"]'),
      page.waitForURL('http://localhost:3000/catalog')
    ]);
  
    await page.click('a[href="/create"]');
  
    await page.waitForSelector('#create-form');
  
    await page.fill('#description', 'This is a test book description');
    await page.fill('#image', 'https://example.com/book-image.jpg');
    await page.selectOption('#type', 'Fiction');
  
    page.on('dialog', async dialog => {
        expect(dialog.type()).toContain('alert');
        expect(dialog.message()).toContain('All fields are required!');
        await dialog.accept();
    })
  
    await page.waitForURL('http://localhost:3000/create');
    expect(page.url()).toBe('http://localhost:3000/create');
  });
  
  test('Submit the Form with Empty Description Field', async ({ page }) => {
    await page.goto('http://localhost:3000/login');
  
    await page.fill('input[name="email"]', 'peter@abv.bg');
    await page.fill('input[name="password"]', '123456');
  
    await Promise.all([
      page.click('input[type="submit"]'),
      page.waitForURL('http://localhost:3000/catalog')
    ]);
  
    await page.click('a[href="/create"]');
  
    await page.waitForSelector('#create-form');
  
    await page.fill('#title', 'Test Book');
    await page.fill('#image', 'https://example.com/book-image.jpg');
    await page.selectOption('#type', 'Fiction');
  
    page.on('dialog', async dialog => {
        expect(dialog.type()).toContain('alert');
        expect(dialog.message()).toContain('All fields are required!');
        await dialog.accept();
    })
  
    await page.waitForURL('http://localhost:3000/create');
    expect(page.url()).toBe('http://localhost:3000/create');
  });

  test('Submit the Form with Empty Image URL Field', async ({ page }) => {
    await page.goto('http://localhost:3000/login');
  
    await page.fill('input[name="email"]', 'peter@abv.bg');
    await page.fill('input[name="password"]', '123456');
  
    await Promise.all([
      page.click('input[type="submit"]'),
      page.waitForURL('http://localhost:3000/catalog')
    ]);
  
    await page.click('a[href="/create"]');
  
    await page.waitForSelector('#create-form');
  
    await page.fill('#title', 'Test Book');
    await page.fill('#description', 'This is a test book description');
    await page.selectOption('#type', 'Fiction');
  
    page.on('dialog', async dialog => {
        expect(dialog.type()).toContain('alert');
        expect(dialog.message()).toContain('All fields are required!');
        await dialog.accept();
    })
  
    await page.waitForURL('http://localhost:3000/create');
    expect(page.url()).toBe('http://localhost:3000/create');
  });

  // "All Books" Page

  test('Verify That All Books Are Displayed', async ({ page }) => {
    await page.goto('http://localhost:3000/login');
    await page.fill('input[name="email"]', 'peter@abv.bg');
    await page.fill('input[name="password"]', '123456');
    
    await Promise.all([
        page.click('input[type="submit"]'),
        page.waitForURL('http://localhost:3000/catalog')
      ]);


    await page.waitForSelector('.dashboard');
    
    const bookElements = await page.$$('.other-books-list li');

    expect(bookElements.length).toBeGreaterThan(0);
});

// "Details" Page

test('Verify That Logged-In User Sees Details Button and Button Works Correctly', async ({ page }) => {
    await page.goto('http://localhost:3000/login');
    await page.fill('input[name="email"]', 'john@abv.bg');
    await page.fill('input[name="password"]', '123456');
    
    await Promise.all([
        page.click('input[type="submit"]'),
        page.waitForURL('http://localhost:3000/catalog')
      ]);


    await page.click('a[href="/catalog"]');
    await page.waitForSelector('.otherBooks');
    await page.click('.otherBooks a.button');
    await page.waitForSelector('.book-information');

    const detailsPageTitle = await page.textContent('.book-information h3');
    expect(detailsPageTitle).toBe('Test Book');
});

test('Verify That Guest User Sees Details Button and Button Works Correctly', async ({ page }) => {
    await page.goto('http://localhost:3000/');
    
    await page.click('a[href="/catalog"]');
    await page.waitForSelector('.otherBooks');
    await page.click('.otherBooks a.button');
    await page.waitForSelector('.book-information');

    const detailsPageTitle = await page.textContent('.book-information h3');
    expect(detailsPageTitle).toBe('Test Book');
});

test('Verify That All Info Is Displayed Correctly', async ({ page }) => {
    await page.goto('http://localhost:3000/');
    
    await page.click('a[href="/catalog"]');
    await page.waitForSelector('.otherBooks');
    await page.click('.otherBooks a.button');
    await page.waitForSelector('.book-information');

    const detailsPageTitle = await page.textContent('.book-information h3');
    const detailsPageType = await page.textContent('.book-information p.type');
    const detailsPageImgSrc = await page.$eval('.book-information p.img img', imgElement => imgElement.src);
    const detailsPageDescription = await page.textContent('.book-description p');

    expect(detailsPageTitle).toBe('Test Book');
    expect(detailsPageType).toBe('Type: Fiction');
    expect(detailsPageImgSrc).toBe('https://example.com/book-image.jpg');
    expect(detailsPageDescription).toBe('This is a test book description'); 
});

// "Logout" Functionality

test('Verify That the "Logout" Button Is Visible', async ({ page }) => {
    await page.goto('http://localhost:3000/login');
    await page.fill('input[name="email"]', 'peter@abv.bg');
    await page.fill('input[name="password"]', '123456');
    await page.click('input[type="submit"]');
  
    // Wait for the "Logout" button to become visible
    await page.waitForSelector('a[href="javascript:void(0)"]');
  
    const logoutLink = await page.$('a[href="javascript:void(0)"]');
  
    const isLinkVisible = await logoutLink.isVisible();
  
    expect(isLinkVisible).toBe(true);
  });
  

test('Verify That the "Logout" Button Redirects Correctly', async ({ page }) => {
    await page.goto('http://localhost:3000/login');
    await page.fill('input[name="email"]', 'peter@abv.bg');
    await page.fill('input[name="password"]', '123456');
    page.click('input[type="submit"]');

    const logoutLink = await page.$('a[href="javascript:void(0)"]');
    await logoutLink.click();

    const redirectURL = page.url();
    expect(redirectURL).toBe('http://localhost:3000/catalog');
});


