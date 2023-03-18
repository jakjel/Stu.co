describe('Search for friends', () => {
    it('search for friends', function () {
      cy.visit('http://localhost:3000')
      
      cy.contains('Sign in').click()
      
      cy.get('input[name=username]').type("daniil")
  
      cy.get('input[name=password]').type("test123")
      cy.contains('Sign in').click()
  
      cy.url().should('include', '/feed')
      cy.visit('http://localhost:3000/friends')
      cy.get('.search_bubble').type("jakjel")
      cy.get('.friend-container').should('contain', 'jakjel')
    })
  })