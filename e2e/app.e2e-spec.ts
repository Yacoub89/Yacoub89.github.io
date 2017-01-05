import { ProfileWebsitePage } from './app.po';

describe('profile-website App', function() {
  let page: ProfileWebsitePage;

  beforeEach(() => {
    page = new ProfileWebsitePage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
